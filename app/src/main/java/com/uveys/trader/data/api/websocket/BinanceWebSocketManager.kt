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

/**
 * Binance Futures WebSocket bağlantı yöneticisi
 */
@Singleton
class BinanceWebSocketManager @Inject constructor() {
    
    private var webSocketClient: WebSocketClient? = null
    
    /**
     * Belirli bir sembol ve zaman aralığı için gerçek zamanlı mum verilerini akış olarak alır
     * @param symbol Kripto para çifti
     * @param interval Zaman aralığı
     * @return Mum verisi akışı
     */
    fun subscribeToKlines(symbol: String, interval: String): Flow<CandleDto> = callbackFlow {
        val wsUrl = "wss://fstream.binance.com/ws/${symbol.lowercase()}@kline_$interval"
        
        val client = object : WebSocketClient(URI(wsUrl)) {
            override fun onOpen(handshakedata: ServerHandshake?) {
                Timber.d("WebSocket bağlantısı açıldı: $wsUrl")
            }
            
            override fun onMessage(message: String?) {
                message?.let {
                    try {
                        val json = JSONObject(it)
                        if (json.has("k")) {
                            val kline = json.getJSONObject("k")
                            val candleDto = CandleDto(
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
                            trySend(candleDto)
                        }
                    } catch (e: Exception) {
                        Timber.e(e, "WebSocket mesajı işlenirken hata oluştu")
                    }
                }
            }
            
            override fun onClose(code: Int, reason: String?, remote: Boolean) {
                Timber.d("WebSocket bağlantısı kapandı: $code, $reason")
            }
            
            override fun onError(ex: Exception?) {
                Timber.e(ex, "WebSocket hatası")
            }
        }
        
        webSocketClient = client
        client.connect()
        
        awaitClose {
            client.close()
        }
    }
    
    /**
     * Belirli bir sembol için anlık fiyat bilgisini akış olarak alır
     * @param symbol Kripto para çifti
     * @return Fiyat akışı
     */
    fun subscribeToPriceStream(symbol: String): Flow<BigDecimal> = callbackFlow {
        val wsUrl = "wss://fstream.binance.com/ws/${symbol.lowercase()}@ticker"
        
        val client = object : WebSocketClient(URI(wsUrl)) {
            override fun onOpen(handshakedata: ServerHandshake?) {
                Timber.d("WebSocket bağlantısı açıldı: $wsUrl")
            }
            
            override fun onMessage(message: String?) {
                message?.let {
                    try {
                        val json = JSONObject(it)
                        if (json.has("c")) {
                            val price = BigDecimal(json.getString("c"))
                            trySend(price)
                        }
                    } catch (e: Exception) {
                        Timber.e(e, "WebSocket mesajı işlenirken hata oluştu")
                    }
                }
            }
            
            override fun onClose(code: Int, reason: String?, remote: Boolean) {
                Timber.d("WebSocket bağlantısı kapandı: $code, $reason")
            }
            
            override fun onError(ex: Exception?) {
                Timber.e(ex, "WebSocket hatası")
            }
        }
        
        webSocketClient = client
        client.connect()
        
        awaitClose {
            client.close()
        }
    }
    
    /**
     * WebSocket bağlantısını kapatır
     */
    fun closeConnection() {
        webSocketClient?.close()
        webSocketClient = null
    }
}
