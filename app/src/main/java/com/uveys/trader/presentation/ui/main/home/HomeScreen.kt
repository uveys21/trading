package com.uveys.trader.presentation.ui.main.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Stop
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.uveys.trader.domain.usecase.TradingSignal
import com.uveys.trader.presentation.viewmodel.MainUiState

/**
 * Ana sayfa ekranı
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    uiState: MainUiState,
    onStartStrategy: (String) -> Unit,
    onStopStrategy: () -> Unit
) {
    var selectedSymbol by remember { mutableStateOf(uiState.selectedSymbol) }
    var showSymbolDialog by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Sembol seçimi ve strateji başlat/durdur
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
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Seçili Parite: $selectedSymbol",
                        style = MaterialTheme.typography.titleMedium
                    )

                    Button(onClick = { showSymbolDialog = true }) {
                        Text("Değiştir")
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Strateji Durumu:",
                        style = MaterialTheme.typography.titleMedium
                    )

                    if (uiState.isStrategyRunning) {
                        Button(
                            onClick = { onStopStrategy() },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = MaterialTheme.colorScheme.error
                            )
                        ) {
                            Icon(
                                imageVector = Icons.Default.Stop,
                                contentDescription = "Durdur",
                                modifier = Modifier.size(ButtonDefaults.IconSize)
                            )
                            Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                            Text("Stratejiyi Durdur")
                        }
                    } else {
                        Button(
                            onClick = { onStartStrategy(selectedSymbol) }
                        ) {
                            Icon(
                                imageVector = Icons.Default.PlayArrow,
                                contentDescription = "Başlat",
                                modifier = Modifier.size(ButtonDefaults.IconSize)
                            )
                            Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                            Text("Stratejiyi Başlat")
                        }
                    }
                }

                // Sinyal göstergesi
                if (uiState.isStrategyRunning) {
                    Spacer(modifier = Modifier.height(16.dp))

                    val signalColor = when (uiState.currentSignal) {
                        TradingSignal.LONG -> Color.Green
                        TradingSignal.SHORT -> Color.Red
                        TradingSignal.NEUTRAL -> Color.Gray
                    }

                    val signalText = when (uiState.currentSignal) {
                        TradingSignal.LONG -> "LONG (ALIŞ) SİNYALİ"
                        TradingSignal.SHORT -> "SHORT (SATIŞ) SİNYALİ"
                        TradingSignal.NEUTRAL -> "NÖTR - BEKLEME MODU"
                    }

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Column(
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                text = signalText,
                                style = MaterialTheme.typography.titleLarge,
                                color = signalColor,
                                fontWeight = FontWeight.Bold
                            )

                            Spacer(modifier = Modifier.height(8.dp))

                            Text(
                                text = "Bağlantı durumu: ${uiState.connectionStatus}",
                                style = MaterialTheme.typography.bodyMedium,
                                color = if (uiState.connectionStatus == "Aktif") Color.Green else Color.Red
                            )

                            if (uiState.connectionLatency > 0) {
                                Text(
                                    text = "Gecikme: ${uiState.connectionLatency}ms",
                                    style = MaterialTheme.typography.bodyMedium
                                )
                            }

                            Text(
                                text = "Kullanılan Kaldıraç: ${uiState.leverage}x",
                                style = MaterialTheme.typography.bodyMedium
                            )

                            Text(
                                text = "Risk Yüzdesi: ${uiState.riskPercentage}%",
                                style = MaterialTheme.typography.bodyMedium
                            )
                        }
                    }
                }
            }
        }

        // Son işlem sonucu
        if (uiState.lastTradeResult.isNotEmpty()) {
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
                        text = "Son İşlem Sonucu:",
                        style = MaterialTheme.typography.titleMedium
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = uiState.lastTradeResult,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
        }

        // Hata mesajı
        if (uiState.errorMessage.isNotEmpty()) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.errorContainer
                )
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Text(
                        text = "Hata:",
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.onErrorContainer
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = uiState.errorMessage,
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onErrorContainer
                    )
                }
            }
        }

        // Açık pozisyonlar
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(
                    text = "Açık Pozisyonlar",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                if (uiState.isLoading) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 32.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator()
                    }
                } else if (uiState.positions.isEmpty()) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 32.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Açık pozisyon bulunmuyor",
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                } else {
                    LazyColumn {
                        items(uiState.positions) { position ->
                            // Position'dan profit bilgisini hesapla (varsayılan değerler)
                            val unrealizedProfit = position.unrealizedProfit?.toDoubleOrNull() ?: 0.0
                            val profitColor = if (unrealizedProfit >= 0) Color.Green else Color.Red
                            val profitPercentage = position.profitPercentage?.toDoubleOrNull() ?: 0.0

                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 8.dp),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Column {
                                    Text(
                                        text = position.symbol,
                                        style = MaterialTheme.typography.bodyLarge,
                                        fontWeight = FontWeight.Bold
                                    )
                                    Text(
                                        text = "${position.positionSide} - ${position.positionAmt}",
                                        style = MaterialTheme.typography.bodyMedium
                                    )
                                }

                                Column(horizontalAlignment = Alignment.End) {
                                    Text(
                                        text = "${String.format("%.2f", unrealizedProfit)} USDT",
                                        style = MaterialTheme.typography.bodyLarge,
                                        color = profitColor,
                                        fontWeight = FontWeight.Bold
                                    )
                                    Text(
                                        text = "${String.format("%.2f", profitPercentage)}%",
                                        style = MaterialTheme.typography.bodyMedium,
                                        color = profitColor
                                    )
                                }
                            }

                            HorizontalDivider(modifier = Modifier.padding(vertical = 4.dp))
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
                LazyColumn {
                    items(symbols) { symbol ->
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