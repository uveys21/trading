# Uveys Trader - Uygulama Mimarisi

## 1. Mimari Genel Bakış

Uveys Trader uygulaması, Clean Architecture ve MVVM (Model-View-ViewModel) tasarım desenlerini temel alarak geliştirilecektir. Bu yaklaşım, kodun test edilebilirliğini, bakımını ve genişletilebilirliğini kolaylaştıracaktır.

### Katmanlı Mimari

```
┌─────────────────────────────────────────────────────────────┐
│                      Presentation Layer                     │
│  ┌─────────────┐  ┌─────────────┐  ┌─────────────────────┐  │
│  │    Views    │  │  ViewModels │  │ UI States/Events    │  │
│  └─────────────┘  └─────────────┘  └─────────────────────┘  │
└───────────────────────────┬─────────────────────────────────┘
                            │
┌───────────────────────────▼─────────────────────────────────┐
│                       Domain Layer                          │
│  ┌─────────────┐  ┌─────────────┐  ┌─────────────────────┐  │
│  │   Entities  │  │ Use Cases   │  │ Repository Interface│  │
│  └─────────────┘  └─────────────┘  └─────────────────────┘  │
└───────────────────────────┬─────────────────────────────────┘
                            │
┌───────────────────────────▼─────────────────────────────────┐
│                        Data Layer                           │
│  ┌─────────────┐  ┌─────────────┐  ┌─────────────────────┐  │
│  │ Repositories│  │ Data Sources│  │ API / Local Storage │  │
│  └─────────────┘  └─────────────┘  └─────────────────────┘  │
└─────────────────────────────────────────────────────────────┘
```

## 2. Katmanlar ve Bileşenler

### 2.1 Presentation Layer (Sunum Katmanı)
- **Activities/Fragments**: Kullanıcı arayüzü bileşenleri
- **ViewModels**: UI mantığını ve durumunu yönetir
- **UI States**: Ekran durumlarını temsil eder
- **UI Events**: Kullanıcı etkileşimlerini temsil eder
- **Adapters**: RecyclerView ve diğer liste bileşenleri için adaptörler
- **Composables**: Jetpack Compose UI bileşenleri

### 2.2 Domain Layer (İş Mantığı Katmanı)
- **Entities**: İş mantığı veri modelleri
- **Use Cases**: İş mantığı işlemleri
- **Repository Interfaces**: Veri erişim soyutlamaları
- **Trading Strategy**: Alım-satım stratejisi algoritmaları

### 2.3 Data Layer (Veri Katmanı)
- **Repositories**: Repository arayüzlerinin uygulamaları
- **Remote Data Sources**: Binance API ile iletişim
- **Local Data Sources**: Room veritabanı ve DataStore
- **DTOs**: Veri transfer nesneleri
- **Mappers**: DTO'ları domain entity'lerine dönüştürücüler

## 3. Modüller ve Paketler

```
com.uveys.trader/
├── di/                  # Bağımlılık enjeksiyonu
├── domain/              # İş mantığı katmanı
│   ├── entity/          # Domain modelleri
│   ├── repository/      # Repository arayüzleri
│   └── usecase/         # İş mantığı use case'leri
├── data/                # Veri katmanı
│   ├── api/             # Binance API servisleri
│   │   ├── rest/        # REST API
│   │   └── websocket/   # WebSocket API
│   ├── db/              # Yerel veritabanı
│   ├── repository/      # Repository uygulamaları
│   ├── dto/             # Veri transfer nesneleri
│   └── mapper/          # DTO-Entity dönüştürücüleri
├── presentation/        # Sunum katmanı
│   ├── ui/              # UI bileşenleri
│   │   ├── auth/        # Giriş ekranı
│   │   ├── main/        # Ana ekran
│   │   ├── trading/     # İşlem ekranı
│   │   └── settings/    # Ayarlar ekranı
│   ├── viewmodel/       # ViewModels
│   └── state/           # UI durum sınıfları
├── util/                # Yardımcı sınıflar
│   ├── security/        # Güvenlik yardımcıları
│   ├── extensions/      # Kotlin uzantıları
│   └── constants/       # Sabitler
└── service/             # Arka plan servisleri
    ├── notification/    # Bildirim servisi
    └── worker/          # WorkManager işleri
```

## 4. Veri Akışı

1. **Kullanıcı Etkileşimi**: Kullanıcı UI ile etkileşime girer
2. **ViewModel**: Etkileşimi işler ve ilgili Use Case'i çağırır
3. **Use Case**: İş mantığını uygular ve Repository'yi çağırır
4. **Repository**: Veri kaynağını seçer (API veya yerel)
5. **Data Source**: Veriyi alır/gönderir ve DTO olarak döndürür
6. **Repository**: DTO'yu Entity'ye dönüştürür
7. **Use Case**: Entity üzerinde işlem yapar
8. **ViewModel**: UI State'i günceller
9. **UI**: Güncel durumu gösterir

## 5. Bağımlılık Enjeksiyonu

Hilt kullanılarak bağımlılıklar yönetilecektir:

```kotlin
@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideBinanceApiService(): BinanceApiService {
        // OkHttp ve Retrofit yapılandırması
    }
    
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
        // Room veritabanı yapılandırması
    }
    
    // Diğer bağımlılıklar...
}
```

## 6. Güvenlik Mimarisi

### 6.1 API Anahtarı Güvenliği
- EncryptedSharedPreferences veya EncryptedFile kullanılarak API anahtarları şifrelenmiş olarak saklanacak
- Android Keystore System ile şifreleme anahtarları güvenli şekilde yönetilecek

### 6.2 Ağ Güvenliği
- SSL pinning ile güvenli bağlantı
- OkHttp interceptor'lar ile istek/yanıt güvenliği

## 7. Teknik Analiz ve İşlem Stratejisi

### 7.1 Teknik Gösterge Hesaplamaları
- Ta4j kütüphanesi kullanılarak teknik göstergeler hesaplanacak
- Özel gösterge sınıfları oluşturulacak (EMA, MACD, RSI)

### 7.2 Strateji Motoru
- Strategy tasarım deseni kullanılarak farklı stratejiler uygulanabilir hale getirilecek
- Observer deseni ile fiyat değişimleri izlenecek

```kotlin
interface TradingStrategy {
    fun analyze(candles: List<Candle>): SignalResult
}

class TripleConfirmationStrategy : TradingStrategy {
    override fun analyze(candles: List<Candle>): SignalResult {
        // EMA, MACD, RSI hesaplamaları ve sinyal üretimi
    }
}
```

## 8. Gerçek Zamanlı Veri Akışı

WebSocket bağlantısı ile gerçek zamanlı veri akışı sağlanacak:

```kotlin
class BinanceWebSocketManager {
    private val webSocketClient: WebSocketClient
    
    fun subscribeToKlines(symbol: String, interval: String): Flow<Kline> {
        // WebSocket bağlantısı ve veri akışı
    }
    
    fun subscribeToTicker(symbol: String): Flow<TickerData> {
        // WebSocket bağlantısı ve veri akışı
    }
}
```

## 9. Çoklu Parite Desteği

- Birden fazla kripto para çiftini izlemek için paralel WebSocket bağlantıları
- WorkManager ile arka planda çoklu parite analizi

## 10. Portföy Takibi

- Room veritabanında işlem geçmişi ve portföy durumu saklanacak
- Gerçek zamanlı kar/zarar hesaplaması

## 11. Strateji Optimizasyonu

- Geçmiş veriler üzerinde strateji parametrelerini test etme
- Genetik algoritma ile optimum parametre bulma

## 12. Ölçeklenebilirlik ve Genişletilebilirlik

- Yeni stratejiler kolayca eklenebilir
- Yeni teknik göstergeler modüler şekilde entegre edilebilir
- Farklı borsalar için adaptörler eklenebilir
