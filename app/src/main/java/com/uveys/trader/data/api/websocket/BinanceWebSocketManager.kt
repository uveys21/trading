package com.uveys.trader.data.api.websocket

import com.uveys.trader.data.dto.CandleDto
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import org.java_websocket.client.WebSocketClient
import org.java_websocket.handshake.ServerHandshake
import org.json.JSONObject
import timber.log.Timber
import java.math.BigDecimal
import java.net.URI
import javax.inject.Inject
import javax.inject.Singleton
import android.util.Log
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.concurrent.ConcurrentHashMap
import kotlinx.coroutines.delay
import org.json.JSONArray
import kotlinx.coroutines.flow.onEach

/**
 * Binance Futures WebSocket bağlantı yöneticisi
 */
@Singleton
class BinanceWebSocketManager @Inject constructor() {

    private var webSocketClient: WebSocketClient? = null
    private val combinedStreamUrl = "wss://fstream.binance.com/ws"
    private val incomingMessages = MutableSharedFlow<String>() // Shared flow for all incoming messages
    private val subscriptionQueue = ConcurrentHashMap<String, MutableList<String>>() // Map of stream type to list of streams
    private val activeSubscriptions = ConcurrentHashMap<String, Boolean>() // Track active subscriptions
    private val scope = CoroutineScope(Dispatchers.IO) // Scope for managing subscriptions
    private val BATCH_SIZE = 25 // Number of streams to subscribe in a single batch
    private val SUBSCRIBE_DELAY_MS = 2000L // Delay between batches

    init {
        connectWebSocket()
        startSubscriptionProcessor()
        Log.d("WebSocketDebug", "BinanceWebSocketManager instance created: ${this.hashCode()}")
    }

    private fun connectWebSocket() {
        Log.d("WebSocketDebug", "Attempting to connect to WebSocket: $combinedStreamUrl")
        if (webSocketClient != null && webSocketClient?.isOpen == true) {
            Log.d("WebSocketDebug", "WebSocket already open.")
            return // Already connected
        }

        webSocketClient = object : WebSocketClient(URI(combinedStreamUrl)) {
            override fun onOpen(handshakedata: ServerHandshake?) {
                Timber.d("WebSocket bağlantısı açıldı: $combinedStreamUrl")
                Log.d("WebSocketDebug", "Opened: $combinedStreamUrl")
                // Process any pending subscriptions on connection open
                processSubscriptionQueue()
            }

            override fun onMessage(message: String?) {
                message?.let {
                    // Emit all incoming messages to the shared flow
                    incomingMessages.tryEmit(it)
                } ?: Log.d("WebSocketDebug", "Received null message")
            }

            override fun onClose(code: Int, reason: String?, remote: Boolean) {
                Timber.d("WebSocket bağlantısı kapandı: $code, $reason")
                Log.d("WebSocketDebug", "Closed: Code: $code, Reason: $reason, Remote: $remote")
                webSocketClient = null // Clean up the client instance
                // Attempt to reconnect after a delay if closed unexpectedly
                if (code != 1000) {
                    Timber.d("Attempting to reconnect WebSocket...")
                    Log.d("WebSocketDebug", "Attempting to reconnect...")
                    // Simple reconnect logic - consider exponential backoff in production
                    scope.launch {
                        delay(5000) // wait 5 seconds before attempting to reconnect
                        connectWebSocket()
                    }
                }
            }

            override fun onError(ex: Exception?) {
                Timber.e(ex, "WebSocket hatası")
                Log.e("WebSocketDebug", "Error: ${ex?.message}")
                // Close connection on error - onClose will handle cleanup and reconnect
                close(1011, "Error occurred") // Use code 1011 for an internal error
            }
        }

        webSocketClient?.connect()
        Log.d("WebSocketDebug", "connect() called on WebSocket client.")
    }

    private fun startSubscriptionProcessor() {
        scope.launch {
            while (true) {
                processSubscriptionQueue()
                delay(SUBSCRIBE_DELAY_MS) // Periodically check and process queue
            }
        }
    }

    private fun processSubscriptionQueue() {
        Log.d("WebSocketDebug", "Processing subscription queue in instance: ${this.hashCode()}. WebSocket open: ${webSocketClient?.isOpen}")
        if (webSocketClient?.isOpen != true) {
            return // Don't process if not connected
        }
        // Process kline subscriptions
        subscriptionQueue["kline"]?.let { klineQueue ->
            Log.d("WebSocketDebug", "Kline queue size: ${klineQueue.size}")
            val klineStreamsToSubscribe = klineQueue.take(BATCH_SIZE)
            Log.d("WebSocketDebug", "Kline batch size to subscribe: ${klineStreamsToSubscribe.size}")
            if (klineStreamsToSubscribe.isNotEmpty()) {
                val subscribeMessage = JSONObject().apply {
                    put("method", "SUBSCRIBE")
                    val paramsArray = JSONArray()
                    klineStreamsToSubscribe.forEach { paramsArray.put(it) }
                    put("params", paramsArray)
                    put("id", System.currentTimeMillis())
                }.toString()
                webSocketClient?.send(subscribeMessage)
                Log.d("WebSocketDebug", "Sent SUBSCRIBE batch for klines: ${klineStreamsToSubscribe.size} streams")
                // Remove processed streams from the queue - perform removal on the list in the map
                subscriptionQueue["kline"]?.removeAll(klineStreamsToSubscribe.toSet())
            }
        } ?: run { Log.d("WebSocketDebug", "Kline queue is null in instance: ${this.hashCode()}.") }
         // TODO: Add processing for other stream types if needed
    }

    /**
     * Belirli bir sembol ve zaman aralığı için gerçek zamanlı mum verilerini akış olarak alır
     * @param symbol Kripto para çifti
     * @return Mum verisi akışı
     */
    fun subscribeToKlines(symbol: String, interval: String): Flow<CandleDto> = callbackFlow {
        val streamName = "${symbol.lowercase()}@kline_$interval"

        Log.d("WebSocketDebug", "subscribeToKlines called for $streamName in instance: ${this@BinanceWebSocketManager.hashCode()}")

        // Add stream to the subscription queue if not already subscribed
        if (!activeSubscriptions.containsKey(streamName)) {
            subscriptionQueue.computeIfAbsent("kline") { 
                Log.d("WebSocketDebug", "Creating new mutable list for kline queue for instance: ${this.hashCode()}")
                mutableListOf() 
            }.add(streamName)
            activeSubscriptions[streamName] = true
            Log.d("WebSocketDebug", "Added $streamName to subscription queue.")
            Log.d("WebSocketDebug", "Queue size after adding $streamName: ${subscriptionQueue["kline"]?.size}")
        }

        // Filter incoming messages for this specific stream
        incomingMessages
            .filter { message ->
                // Robust filtering for combined stream format
                try {
                    val json = JSONObject(message)
                    // Corrected filtering logic: check 'e' for event type and 's' for symbol
                    val eventType = json.optString("e")
                    val symbolInMessage = json.optString("s")
                    val isKlineMessage = eventType == "kline" && symbolInMessage.equals(symbol, ignoreCase = true)

                    isKlineMessage
                } catch (e: Exception) {
                    false // Not a valid JSON message or missing required fields
                }
            }
            .map { message ->
                // Parse the kline data from the message
                val json = JSONObject(message)
                val kline = json.getJSONObject("data").getJSONObject("k") // Kline data is nested under 'data'
                 CandleDto(
                    openTime = kline.getLong("t"),
                    open = kline.getString("o"),
                    high = kline.getString("h"),
                    low = kline.getString("l"),
                    close = kline.getString("c"),
                    volume = kline.getString("v"),
                    closeTime = kline.getLong("T"),
                    quoteAssetVolume = kline.getString("q"),
                    numberOfTrades = kline.getInt("n"),
                    takerBuyBaseAssetVolume = kline.getString("V"),
                    takerBuyQuoteAssetVolume = kline.getString("Q")
                )
            }
            .collect { candleDto ->
                trySend(candleDto)
            }

        awaitClose {
            // Send unsubscribe message when the collector cancels
            activeSubscriptions.remove(streamName)
            val unsubscribeMessage = JSONObject().apply {
                put("method", "UNSUBSCRIBE")
                val paramsArray = JSONArray()
                paramsArray.put(streamName)
                put("params", paramsArray)
                put("id", System.currentTimeMillis()) // Unique ID
            }.toString()
            webSocketClient?.send(unsubscribeMessage)
            Log.d("WebSocketDebug", "Sent unsubscribe message for $streamName")
        }
    }

    /**
     * Belirli bir sembol için anlık fiyat bilgisini akış olarak alır
     * @param symbol Kripto para çifti
     * @return Fiyat akışı
     */
    fun subscribeToPriceStream(symbol: String): Flow<BigDecimal> = callbackFlow {
        // Refactor this to use the single connection and add to subscriptionQueue similar to klines
        val streamName = "${symbol.lowercase()}@ticker"
        Log.d("WebSocketDebug", "subscribeToPriceStream called for $streamName in instance: ${this@BinanceWebSocketManager.hashCode()}")
        // Add stream to the subscription queue if not already subscribed
        if (!activeSubscriptions.containsKey(streamName)) {
            subscriptionQueue.computeIfAbsent("ticker") { mutableListOf() }.add(streamName)
            activeSubscriptions[streamName] = true
            Log.d("WebSocketDebug", "Added $streamName to subscription queue.")
            // Trigger immediate processing attempt (will only send if connected and batch is ready)
            processSubscriptionQueue()
        }

        incomingMessages
            .filter { message ->
                try {
                    val json = JSONObject(message)
                    json.has("stream") && json.getString("stream") == streamName && json.has("data")
                } catch (e: Exception) {
                    false
                }
            }
            .map { message ->
                val json = JSONObject(message)
                val price = BigDecimal(json.getJSONObject("data").getString("c")) // Price is under 'data' and 'c'
                price
            }
            .collect { price ->
                trySend(price)
                // Log.d("WebSocketDebug", "Emitted price for $streamName")
            }

        awaitClose {
            activeSubscriptions.remove(streamName)
            val unsubscribeMessage = JSONObject().apply {
                put("method", "UNSUBSCRIBE")
                val paramsArray = JSONArray()
                paramsArray.put(streamName)
                put("params", paramsArray)
                put("id", System.currentTimeMillis())
            }.toString()
            webSocketClient?.send(unsubscribeMessage)
            Log.d("WebSocketDebug", "Sent unsubscribe message for $streamName")
        }
    }

    /**
     * WebSocket bağlantısını kapatır
     */
    fun closeConnection() {
        webSocketClient?.close(1000, "App Closing") // Use code 1000 for normal closure
        Log.d("WebSocketDebug", "Closed WebSocket connection manually.")
    }
}

