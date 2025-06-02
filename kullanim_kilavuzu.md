# Uveys Trader - Kullanım Kılavuzu

## İçindekiler
1. Giriş
2. Kurulum ve Başlangıç
3. Ana Ekranlar ve Özellikler
4. Ticaret Stratejisi
5. Güvenlik Bilgileri
6. Sık Sorulan Sorular

## 1. Giriş

Uveys Trader, Binance Futures API'si kullanarak teknik göstergelere dayalı kripto alım-satım işlemleri yapmanızı sağlayan profesyonel bir Android uygulamasıdır. Uygulama, "Üçlü Onaylı Trend Sistemi" adı verilen bir strateji kullanarak LONG ve SHORT pozisyonlar açabilir, aynı zamanda manuel işlem yapmanıza da olanak tanır.

## 2. Kurulum ve Başlangıç

### Sistem Gereksinimleri
- Android 8.0 veya üzeri
- İnternet bağlantısı
- Binance Futures hesabı

### API Anahtarı Oluşturma
1. Binance hesabınıza giriş yapın
2. "API Yönetimi" bölümüne gidin
3. Yeni API anahtarı oluşturun
4. Aşağıdaki izinleri etkinleştirin:
   - Futures hesabı okuma
   - Futures işlem yapma
5. API Key ve Secret'ı güvenli bir şekilde saklayın

### Uygulamaya Giriş
1. Uygulamayı açın
2. API Key ve Secret'ınızı ilgili alanlara girin
3. "Giriş Yap" butonuna tıklayın
4. Alternatif olarak "Demo Modu" ile gerçek para kullanmadan uygulamayı test edebilirsiniz

## 3. Ana Ekranlar ve Özellikler

### Ana Sayfa
- Seçili kripto para çiftini gösterir
- Stratejiyi başlatma/durdurma kontrollerini içerir
- Mevcut sinyal durumunu (LONG/SHORT/NÖTR) gösterir
- Açık pozisyonları listeler

### İşlem Ekranı
- Teknik göstergeleri canlı olarak gösterir (EMA, RSI, MACD)
- Manuel işlem yapmanızı sağlar
- Market ve Limit emirleri oluşturabilirsiniz
- LONG veya SHORT pozisyon seçebilirsiniz

### Portföy Ekranı
- Açık pozisyonlarınızı detaylı şekilde gösterir
- İşlem geçmişinizi listeler
- Kar/zarar durumunuzu takip edebilirsiniz

### Ayarlar Ekranı
- Kaldıraç oranını ayarlayabilirsiniz (1-125)
- Risk yüzdesini belirleyebilirsiniz (0.1-5%)
- Tema ayarlarını değiştirebilirsiniz
- Bildirim tercihlerini yönetebilirsiniz
- Çıkış yapabilirsiniz

## 4. Ticaret Stratejisi

### Üçlü Onaylı Trend Sistemi

#### LONG (Alış) Sinyali Koşulları:
- 50 EMA > 200 EMA
- MACD çizgisi > Sinyal çizgisi
- RSI > 50 (ama < 70)

#### SHORT (Satış) Sinyali Koşulları:
- 50 EMA < 200 EMA
- MACD çizgisi < Sinyal çizgisi
- RSI < 50 (ama > 30)

#### Risk Yönetimi:
- Stop-loss: %2
- Take-profit: %4
- Zaman dilimi: 15 dakikalık mumlar
- Pozisyon başına maksimum risk: Bakiyenizin %1'i

## 5. Güvenlik Bilgileri

- API anahtarlarınız cihazınızda AES şifreleme ile güvenli şekilde saklanır
- Anahtarlarınız Binance dışında hiçbir sunucuya gönderilmez
- Tüm ağ bağlantıları SSL üzerinden yapılır
- Hatalı API kullanımında uyarı alırsınız ve işlem engellenir

## 6. Sık Sorulan Sorular

**S: Uygulamayı kullanmak için Binance hesabı gerekli mi?**
C: Evet, gerçek işlem yapmak için Binance Futures hesabına ve API anahtarlarına ihtiyacınız vardır. Ancak "Demo Modu" ile gerçek para kullanmadan uygulamayı test edebilirsiniz.

**S: API anahtarlarım güvenli mi?**
C: Evet, API anahtarlarınız cihazınızda AES şifreleme ile güvenli şekilde saklanır ve Binance dışında hiçbir sunucuya gönderilmez.

**S: Uygulama hangi kripto para çiftlerini destekliyor?**
C: Uygulama, Binance Futures'da işlem gören tüm kripto para çiftlerini destekler. Popüler çiftler arasında BTCUSDT, ETHUSDT, BNBUSDT, ADAUSDT, DOGEUSDT ve XRPUSDT bulunmaktadır.

**S: Otomatik işlem açma/kapama nasıl çalışır?**
C: Stratejiyi başlattığınızda, uygulama seçili kripto para çiftini sürekli izler ve "Üçlü Onaylı Trend Sistemi" koşulları sağlandığında otomatik olarak işlem açar. Stop-loss ve take-profit emirleri de otomatik olarak yerleştirilir.

**S: Kaldıraç oranını nasıl değiştirebilirim?**
C: Ayarlar ekranından kaldıraç oranını 1 ile 125 arasında ayarlayabilirsiniz. Yüksek kaldıraç oranları daha yüksek risk içerir.

**S: Uygulama internet bağlantısı kesilirse ne olur?**
C: İnternet bağlantısı kesilirse, uygulama otomatik işlemleri durdurur ve bağlantı yeniden sağlandığında sizi bilgilendirir. Açık pozisyonlarınız Binance'ta kalmaya devam eder.

**S: Uygulamayı kullanmak için ücret ödemem gerekiyor mu?**
C: Hayır, uygulama ücretsizdir. Sadece Binance'ın işlem ücretleri geçerlidir.

**S: Teknik göstergeler nasıl hesaplanır?**
C: Teknik göstergeler, Ta4j kütüphanesi kullanılarak hesaplanır ve 15 dakikalık mum verileri üzerinde çalışır.

**S: Uygulama ne kadar güvenilir?**
C: Uygulama, kapsamlı testlerden geçirilmiştir. Ancak, kripto para ticareti doğası gereği risklidir ve sermayenizin tamamını kaybetmenize neden olabilir. Sadece kaybetmeyi göze alabileceğiniz miktarla işlem yapmanızı öneririz.
