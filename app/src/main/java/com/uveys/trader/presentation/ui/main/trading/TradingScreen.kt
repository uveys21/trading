package com.uveys.trader.presentation.ui.main.trading

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Error
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.uveys.trader.domain.entity.OrderSide
import com.uveys.trader.domain.entity.PositionSide
import com.uveys.trader.presentation.viewmodel.MainUiState
import com.uveys.trader.domain.usecase.TradingSignal
import java.math.BigDecimal
import androidx.compose.foundation.clickable
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Stop
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.RadioButton
import com.uveys.trader.presentation.viewmodel.MainViewModel
import androidx.hilt.navigation.compose.hiltViewModel

/**
 * İşlem ekranı - Manuel alım/satım emirleri oluşturma
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TradingScreen(
    onPlaceOrder: (String, OrderSide, PositionSide, BigDecimal?, BigDecimal) -> Unit,
    viewModel: MainViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    var selectedSymbol by remember { mutableStateOf(uiState.selectedSymbol) }
    var showSymbolDialog by remember { mutableStateOf(false) }

    var orderType by remember { mutableStateOf("MARKET") }
    var positionSide by remember { mutableStateOf(PositionSide.LONG) }
    var quantity by remember { mutableStateOf("") }
    var price by remember { mutableStateOf("") }

    val scrollState = rememberScrollState()
    var inputErrorMessage by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(scrollState)
    ) {
        // Teknik göstergeler kartı
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(
                    text = "Teknik Göstergeler - $selectedSymbol",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Button(onClick = { showSymbolDialog = true }) {
                        Text("Parite Değiştir")
                    }

                    // Sinyal göstergesi
                    val signalColor = when (uiState.currentSignal) {
                        TradingSignal.LONG -> Color.Green
                        TradingSignal.SHORT -> Color.Red
                        TradingSignal.NEUTRAL -> Color.Gray
                        else -> Color.Gray
                    }

                    val signalText = when (uiState.currentSignal) {
                        TradingSignal.LONG -> "LONG"
                        TradingSignal.SHORT -> "SHORT"
                        TradingSignal.NEUTRAL -> "NÖTR"
                        else -> "NÖTR"
                    }

                    Text(
                        text = "Sinyal: $signalText",
                        style = MaterialTheme.typography.titleMedium,
                        color = signalColor,
                        fontWeight = FontWeight.Bold
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Teknik gösterge değerleri
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column {
                        Text("EMA (50)", style = MaterialTheme.typography.bodyMedium)
                        Text("EMA (200)", style = MaterialTheme.typography.bodyMedium)
                    }

                    Column(horizontalAlignment = Alignment.End) {
                        Text(
                            text = "28,450.25",
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "27,980.10",
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }

                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column {
                        Text("RSI (14)", style = MaterialTheme.typography.bodyMedium)
                        Text("MACD", style = MaterialTheme.typography.bodyMedium)
                    }

                    Column(horizontalAlignment = Alignment.End) {
                        Text(
                            text = "58.25",
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "125.45",
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        }

        // Otomatik İşlem Kartı
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(
                    text = "Otomatik İşlem",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                // Otomatik İşlem Durumu
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Durum: ${if (uiState.isAutoTradingRunning) "Çalışıyor" else "Durduruldu"}",
                        style = MaterialTheme.typography.bodyMedium,
                        color = if (uiState.isAutoTradingRunning) Color.Green else Color.Red
                    )

                    // Başlat/Durdur Butonu
                    Button(
                        onClick = {
                            if (uiState.isAutoTradingRunning) {
                                viewModel.stopAutoTrading()
                            } else {
                                viewModel.startAutoTrading(uiState.autoTradePosition)
                            }
                        }
                    ) {
                        Icon(imageVector = if (uiState.isAutoTradingRunning) Icons.Default.Stop else Icons.Default.PlayArrow, contentDescription = null)
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(if (uiState.isAutoTradingRunning) "Durdur" else "Başlat")
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Pozisyon Seçimi (Radyo Butonları)
                Text(
                    text = "Hedef Pozisyon",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // LONG Pozisyonu
                    Row(
                        modifier = Modifier
                            .selectable(
                                selected = uiState.autoTradePosition == PositionSide.LONG,
                                onClick = {
                                    Log.d("AutoTradeUI", "LONG radio button clicked.")
                                    viewModel.setAutoTradePosition(PositionSide.LONG)
                                }
                            )
                            .padding(horizontal = 16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = uiState.autoTradePosition == PositionSide.LONG,
                            onClick = {
                                Log.d("AutoTradeUI", "LONG radio button (inner) clicked.")
                                viewModel.setAutoTradePosition(PositionSide.LONG)
                            }
                        )
                        Text("LONG")
                    }

                    // SHORT Pozisyonu
                    Row(
                        modifier = Modifier
                            .selectable(
                                selected = uiState.autoTradePosition == PositionSide.SHORT,
                                onClick = {
                                    Log.d("AutoTradeUI", "SHORT radio button clicked.")
                                    viewModel.setAutoTradePosition(PositionSide.SHORT)
                                }
                            )
                            .padding(horizontal = 16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = uiState.autoTradePosition == PositionSide.SHORT,
                            onClick = {
                                Log.d("AutoTradeUI", "SHORT radio button (inner) clicked.")
                                viewModel.setAutoTradePosition(PositionSide.SHORT)
                            }
                        )
                        Text("SHORT")
                    }

                    // Hepsi (LONG ve SHORT)
                    Row(
                        modifier = Modifier
                            .selectable(
                                selected = uiState.autoTradePosition == null,
                                onClick = { viewModel.setAutoTradePosition(null) }
                            )
                            .padding(horizontal = 16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = uiState.autoTradePosition == null,
                            onClick = { viewModel.setAutoTradePosition(null) }
                        )
                        Text("Hepsi")
                    }
                }
            }
        }

        // Manuel işlem kartı
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(
                    text = "Manuel İşlem",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                Text(
                    text = "Kullanılabilir Bakiye: ${uiState.balance} USDT",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(bottom = 16.dp)
                )

                // Emir tipi seçimi
                Text(
                    text = "Emir Tipi",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    FilterChip(
                        selected = orderType == "MARKET",
                        onClick = { orderType = "MARKET" },
                        label = { Text("Market") }
                    )

                    FilterChip(
                        selected = orderType == "LIMIT",
                        onClick = { orderType = "LIMIT" },
                        label = { Text("Limit") }
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Pozisyon yönü seçimi
                Text(
                    text = "Pozisyon Yönü",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    FilterChip(
                        selected = positionSide == PositionSide.LONG,
                        onClick = { positionSide = PositionSide.LONG },
                        label = { Text("LONG") }
                    )

                    FilterChip(
                        selected = positionSide == PositionSide.SHORT,
                        onClick = { positionSide = PositionSide.SHORT },
                        label = { Text("SHORT") }
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Miktar girişi
                OutlinedTextField(
                    value = quantity,
                    onValueChange = { quantity = it },
                    label = { Text("Miktar") },
                    modifier = Modifier.fillMaxWidth(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                    singleLine = true,
                    isError = inputErrorMessage.isNotEmpty()
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Limit emri için fiyat girişi
                if (orderType == "LIMIT") {
                    OutlinedTextField(
                        value = price,
                        onValueChange = { price = it },
                        label = { Text("Fiyat") },
                        modifier = Modifier.fillMaxWidth(),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                        singleLine = true,
                        isError = inputErrorMessage.isNotEmpty()
                    )

                    Spacer(modifier = Modifier.height(16.dp))
                }

                // İşlem butonları
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Button(
                        onClick = {
                            // Input validation
                            if (quantity.isEmpty()) {
                                inputErrorMessage = "Lütfen miktar giriniz."
                                return@Button
                            }

                            if (orderType == "LIMIT" && price.isEmpty()) {
                                inputErrorMessage = "Limit işlemi için fiyat girilmelidir."
                                return@Button
                            }

                            try {
                                val side = if (positionSide == PositionSide.LONG) OrderSide.BUY else OrderSide.SELL
                                val priceValue = if (orderType == "LIMIT") BigDecimal(price) else null
                                val quantityValue = BigDecimal(quantity)

                                onPlaceOrder(selectedSymbol, side, positionSide, priceValue, quantityValue)
                                inputErrorMessage = ""
                            } catch (e: Exception) {
                                inputErrorMessage = "Giriş hatası: ${e.message}"
                            }
                        },
                        modifier = Modifier.weight(1f),
                        enabled = quantity.isNotEmpty() && (orderType != "LIMIT" || price.isNotEmpty())
                    ) {
                        Text("İşlemi Gerçekleştir")
                    }
                }

                // Giriş hatalarını göster
                if (inputErrorMessage.isNotEmpty()) {
                    Spacer(modifier = Modifier.height(8.dp))
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(vertical = 4.dp)
                    ) {
                        Icon(
                            Icons.Filled.Error,
                            contentDescription = "Hata",
                            tint = Color.Red,
                            modifier = Modifier.size(20.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = inputErrorMessage,
                            color = Color.Red,
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                }

                // İşlem sonuçlarını göster
                if (uiState.lastTradeDetails.isNotEmpty()) {
                    Spacer(modifier = Modifier.height(16.dp))

                    val (bgColor, textColor, icon) = when {
                        uiState.lastTradeDetails.startsWith("Hata:") ->
                            Triple(
                                Color.Red.copy(alpha = 0.1f),
                                Color.Red,
                                Icons.Filled.Error
                            )
                        else ->
                            Triple(
                                Color.Green.copy(alpha = 0.1f),
                                Color(0xFF388E3C),
                                Icons.Filled.CheckCircle
                            )
                    }

                    Surface(
                        color = bgColor,
                        shape = RoundedCornerShape(8.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.padding(16.dp)
                        ) {
                            Icon(
                                icon,
                                contentDescription = null,
                                tint = textColor,
                                modifier = Modifier.size(24.dp)
                            )
                            Spacer(modifier = Modifier.width(12.dp))
                            Text(
                                text = uiState.lastTradeDetails,
                                color = textColor,
                                fontWeight = FontWeight.Bold,
                                style = MaterialTheme.typography.bodyLarge
                            )
                        }
                    }
                }
            }
        }
    }

    // Sembol seçim dialogu
    if (showSymbolDialog) {
        val symbols = listOf("BTCUSDT", "ETHUSDT", "BNBUSDT", "ADAUSDT", "DOGEUSDT", "XRPUSDT")

        AlertDialog(
            onDismissRequest = { showSymbolDialog = false },
            title = { Text("Parite Seç") },
            text = {
                Column {
                    symbols.forEach { symbol ->
                        TextButton(
                            onClick = {
                                selectedSymbol = symbol
                                showSymbolDialog = false
                            },
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(symbol)
                        }
                    }
                }
            },
            confirmButton = {
                TextButton(onClick = { showSymbolDialog = false }) {
                    Text("İptal")
                }
            }
        )
    }
}