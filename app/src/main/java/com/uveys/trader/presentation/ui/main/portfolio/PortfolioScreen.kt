package com.uveys.trader.presentation.ui.main.portfolio

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.uveys.trader.domain.entity.Order
import com.uveys.trader.domain.entity.Position

/**
 * Portföy ekranı - Açık pozisyonlar ve işlem geçmişi
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PortfolioScreen(
    positions: List<Position>,
    orderHistory: List<Order>
) {
    var selectedTab by remember { mutableStateOf(0) }
    val tabs = listOf("Açık Pozisyonlar", "İşlem Geçmişi")
    
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        TabRow(selectedTabIndex = selectedTab) {
            tabs.forEachIndexed { index, title ->
                Tab(
                    text = { Text(title) },
                    selected = selectedTab == index,
                    onClick = { selectedTab = index }
                )
            }
        }
        
        when (selectedTab) {
            0 -> PositionsTab(positions)
            1 -> OrderHistoryTab(orderHistory)
        }
    }
}

@Composable
fun PositionsTab(positions: List<Position>) {
    if (positions.isEmpty()) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Açık pozisyon bulunmuyor",
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    } else {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 16.dp)
        ) {
            items(positions) { position ->
                PositionItem(position)
            }
        }
    }
}

@Composable
fun PositionItem(position: Position) {
    val profitColor = if (position.isInProfit) Color.Green else Color.Red
    
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = position.symbol,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
                
                Text(
                    text = position.positionSide.name,
                    style = MaterialTheme.typography.titleMedium,
                    color = if (position.positionSide.name == "LONG") Color.Green else Color.Red
                )
            }
            
            Spacer(modifier = Modifier.height(8.dp))
            
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text(
                        text = "Giriş Fiyatı",
                        style = MaterialTheme.typography.bodyMedium
                    )
                    Text(
                        text = position.entryPrice.toPlainString(),
                        style = MaterialTheme.typography.bodyLarge,
                        fontWeight = FontWeight.Bold
                    )
                }
                
                Column(horizontalAlignment = Alignment.End) {
                    Text(
                        text = "Güncel Fiyat",
                        style = MaterialTheme.typography.bodyMedium
                    )
                    Text(
                        text = position.markPrice.toPlainString(),
                        style = MaterialTheme.typography.bodyLarge,
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
                    Text(
                        text = "Miktar",
                        style = MaterialTheme.typography.bodyMedium
                    )
                    Text(
                        text = position.positionAmt.toPlainString(),
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
                
                Column(horizontalAlignment = Alignment.End) {
                    Text(
                        text = "Kaldıraç",
                        style = MaterialTheme.typography.bodyMedium
                    )
                    Text(
                        text = "${position.leverage}x",
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            }
            
            Spacer(modifier = Modifier.height(16.dp))
            
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Kar/Zarar:",
                    style = MaterialTheme.typography.titleMedium
                )
                
                Column(horizontalAlignment = Alignment.End) {
                    Text(
                        text = "${position.unrealizedProfit} USDT",
                        style = MaterialTheme.typography.titleMedium,
                        color = profitColor,
                        fontWeight = FontWeight.Bold
                    )
                    
                    Text(
                        text = "${position.profitPercentage}%",
                        style = MaterialTheme.typography.bodyMedium,
                        color = profitColor
                    )
                }
            }
        }
    }
}

@Composable
fun OrderHistoryTab(orderHistory: List<Order>) {
    if (orderHistory.isEmpty()) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "İşlem geçmişi bulunmuyor",
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    } else {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 16.dp)
        ) {
            items(orderHistory) { order ->
                OrderItem(order)
            }
        }
    }
}

@Composable
fun OrderItem(order: Order) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = order.symbol,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
                
                Text(
                    text = order.status.name,
                    style = MaterialTheme.typography.bodyMedium,
                    color = when (order.status.name) {
                        "FILLED" -> Color.Green
                        "CANCELED", "REJECTED", "EXPIRED" -> Color.Red
                        else -> MaterialTheme.colorScheme.onSurface
                    }
                )
            }
            
            Spacer(modifier = Modifier.height(8.dp))
            
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text(
                        text = "Emir Tipi",
                        style = MaterialTheme.typography.bodyMedium
                    )
                    Text(
                        text = "${order.side.name} ${order.type.name}",
                        style = MaterialTheme.typography.bodyLarge,
                        color = if (order.side.name == "BUY") Color.Green else Color.Red
                    )
                }
                
                Column(horizontalAlignment = Alignment.End) {
                    Text(
                        text = "Pozisyon",
                        style = MaterialTheme.typography.bodyMedium
                    )
                    Text(
                        text = order.positionSide.name,
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            }
            
            Spacer(modifier = Modifier.height(8.dp))
            
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text(
                        text = "Miktar",
                        style = MaterialTheme.typography.bodyMedium
                    )
                    Text(
                        text = "${order.executedQty}/${order.origQty}",
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
                
                Column(horizontalAlignment = Alignment.End) {
                    Text(
                        text = "Fiyat",
                        style = MaterialTheme.typography.bodyMedium
                    )
                    Text(
                        text = if (order.avgPrice > java.math.BigDecimal.ZERO) order.avgPrice.toPlainString() else order.price.toPlainString(),
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            }
        }
    }
}
