# Uveys Trader - Google Play Store Açıklaması

## Kısa Açıklama
Binance Futures API'si ile çalışan, teknik göstergelere dayalı kripto alım-satım uygulaması.

## Tam Açıklama
Uveys Trader, Binance Futures API'si kullanarak gerçek zamanlı kripto para alım-satımı yapmanızı sağlayan profesyonel bir ticaret uygulamasıdır. Deneyimli yatırımcılar için tasarlanmış olan uygulama, teknik göstergelere dayalı kazançlı alım-satım sinyalleri üretir.

### Temel Özellikler:
- Binance Futures API bağlantısı (REST + WebSocket)
- API Key / Secret güvenli saklama (AES şifreleme)
- Gerçek zamanlı kripto veri akışı
- Alım/satım emirleri oluşturma (Market, Limit)
- Teknik analiz göstergeleri (EMA, RSI, MACD) hesaplaması
- "Üçlü Onaylı Trend Sistemi" stratejisi
- Otomatik işlem açma/kapama
- Manuel işlem yapabilme
- İşlem geçmişi ve kar/zarar tablosu
- Portföy takibi
- Karanlık tema / modern UI (Material 3)

### İşlem Stratejisi:
Uygulama, "Üçlü Onaylı Trend Sistemi" adı verilen bir strateji kullanır:

Long (Alış) Koşulu:
- 50 EMA > 200 EMA
- MACD çizgisi > Sinyal çizgisi
- RSI > 50 (ama < 70)

Short (Satış) Koşulu:
- 50 EMA < 200 EMA
- MACD çizgisi < Sinyal çizgisi
- RSI < 50 (ama > 30)

### Güvenlik:
- API anahtarları yalnızca yerel cihazda AES ile şifreli olarak saklanır
- Ağ bağlantıları SSL üzerinden yapılır
- Hatalı API kullanımında kullanıcı uyarılır ve işlem engellenir

### Uyarı:
Bu uygulama, kripto para ticareti konusunda deneyimli kullanıcılar için tasarlanmıştır. Kripto para ticareti yüksek risk içerir ve sermayenizin tamamını kaybetmenize neden olabilir. Sadece kaybetmeyi göze alabileceğiniz miktarla işlem yapınız.

### Gereksinimler:
- Android 8.0 veya üzeri
- Binance Futures hesabı ve API anahtarları
- İnternet bağlantısı

### İletişim:
Sorularınız veya geri bildirimleriniz için: uveystrader@example.com
