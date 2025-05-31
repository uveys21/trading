package com.uveys.trader.presentation.ui.main.settings

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Logout
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * Ayarlar ekranı - Kaldıraç, risk yüzdesi ve diğer ayarlar
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(
    onLogout: () -> Unit,
    onSetLeverage: (Int) -> Unit,
    onSetRiskPercentage: (Double) -> Unit,
    currentLeverage: Int,
    currentRiskPercentage: Double
) {
    var leverage by remember { mutableStateOf(currentLeverage.toString()) }
    var riskPercentage by remember { mutableStateOf(currentRiskPercentage.toString()) }
    var isDarkTheme by remember { mutableStateOf(true) }
    var showNotifications by remember { mutableStateOf(true) }
    
    val scrollState = rememberScrollState()
    
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(scrollState)
    ) {
        // İşlem Ayarları
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
                    text = "İşlem Ayarları",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                
                // Kaldıraç ayarı
                Text(
                    text = "Kaldıraç Oranı",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                
                OutlinedTextField(
                    value = leverage,
                    onValueChange = { leverage = it },
                    label = { Text("Kaldıraç") },
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true
                )
                
                Spacer(modifier = Modifier.height(8.dp))
                
                Text(
                    text = "Kaldıraç oranı 1-125 arasında olmalıdır",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                
                Spacer(modifier = Modifier.height(16.dp))
                
                // Risk yüzdesi ayarı
                Text(
                    text = "Risk Yüzdesi",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                
                OutlinedTextField(
                    value = riskPercentage,
                    onValueChange = { riskPercentage = it },
                    label = { Text("Risk Yüzdesi") },
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true
                )
                
                Spacer(modifier = Modifier.height(8.dp))
                
                Text(
                    text = "Her işlemde bakiyenizin yüzde kaçını riske edeceğinizi belirler (0.1-5)",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                
                Spacer(modifier = Modifier.height(16.dp))
                
                Button(
                    onClick = {
                        try {
                            val leverageValue = leverage.toInt()
                            if (leverageValue in 1..125) {
                                onSetLeverage(leverageValue)
                            }
                            
                            val riskValue = riskPercentage.toDouble()
                            if (riskValue in 0.1..5.0) {
                                onSetRiskPercentage(riskValue)
                            }
                        } catch (e: Exception) {
                            // Hatalı giriş durumunda işlem yapma
                        }
                    },
                    modifier = Modifier.align(Alignment.End)
                ) {
                    Text("Kaydet")
                }
            }
        }
        
        // Uygulama Ayarları
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
                    text = "Uygulama Ayarları",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                
                // Karanlık tema ayarı
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Karanlık Tema",
                        style = MaterialTheme.typography.bodyLarge
                    )
                    
                    Switch(
                        checked = isDarkTheme,
                        onCheckedChange = { isDarkTheme = it }
                    )
                }
                
                // Bildirim ayarı
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Bildirimleri Göster",
                        style = MaterialTheme.typography.bodyLarge
                    )
                    
                    Switch(
                        checked = showNotifications,
                        onCheckedChange = { showNotifications = it }
                    )
                }
            }
        }
        
        // Hesap Ayarları
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
                    text = "Hesap Ayarları",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                
                Button(
                    onClick = { onLogout() },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.error
                    )
                ) {
                    Icon(
                        imageVector = Icons.Default.Logout,
                        contentDescription = "Çıkış Yap",
                        modifier = Modifier.size(ButtonDefaults.IconSize)
                    )
                    Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                    Text("Çıkış Yap")
                }
            }
        }
        
        // Uygulama Bilgileri
        Card(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(
                    text = "Uygulama Bilgileri",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                
                Text(
                    text = "Uveys Trader",
                    style = MaterialTheme.typography.bodyLarge
                )
                
                Text(
                    text = "Sürüm: 1.0.0",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                
                Spacer(modifier = Modifier.height(8.dp))
                
                Text(
                    text = "© 2025 Uveys Trader. Tüm hakları saklıdır.",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}
