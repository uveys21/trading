package com.uveys.trader.util.security

import android.util.Base64
import okhttp3.Interceptor
import okhttp3.Response
import timber.log.Timber
import java.security.InvalidKeyException
import java.security.NoSuchAlgorithmException
import javax.crypto.Mac
import javax.crypto.spec.SecretKeySpec
import javax.inject.Inject

/**
 * Binance API isteklerine imza ekleyen OkHttp interceptor
 */
class BinanceAuthInterceptor @Inject constructor(
    private val securePreferencesManager: SecurePreferencesManager
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val apiKey = securePreferencesManager.getApiKey()
        val apiSecret = securePreferencesManager.getApiSecret()
        
        if (apiKey.isNullOrEmpty() || apiSecret.isNullOrEmpty()) {
            Timber.e("API anahtarları bulunamadı")
            return chain.proceed(originalRequest)
        }
        
        // Sadece özel API isteklerine imza ekle
        if (!originalRequest.url.toString().contains("/fapi/v")) {
            return chain.proceed(originalRequest)
        }
        
        try {
            // API Key header'ı ekle
            val requestWithApiKey = originalRequest.newBuilder()
                .addHeader("X-MBX-APIKEY", apiKey)
                .build()
            
            // Timestamp parametresi içeren istekler için imza ekle
            val url = originalRequest.url
            if (url.queryParameter("timestamp") != null) {
                val queryString = url.query ?: ""
                val signature = generateSignature(queryString, apiSecret)
                
                val newUrl = url.newBuilder()
                    .addQueryParameter("signature", signature)
                    .build()
                
                val signedRequest = requestWithApiKey.newBuilder()
                    .url(newUrl)
                    .build()
                
                return chain.proceed(signedRequest)
            }
            
            return chain.proceed(requestWithApiKey)
            
        } catch (e: Exception) {
            Timber.e(e, "İmza oluşturulurken hata oluştu")
            return chain.proceed(originalRequest)
        }
    }
    
    /**
     * HMAC SHA256 imzası oluşturur
     */
    @Throws(NoSuchAlgorithmException::class, InvalidKeyException::class)
    private fun generateSignature(data: String, key: String): String {
        val secretKeySpec = SecretKeySpec(key.toByteArray(), "HmacSHA256")
        val mac = Mac.getInstance("HmacSHA256")
        mac.init(secretKeySpec)
        val hmacSha256 = mac.doFinal(data.toByteArray())
        return bytesToHex(hmacSha256)
    }
    
    /**
     * Byte dizisini hexadecimal string'e dönüştürür
     */
    private fun bytesToHex(bytes: ByteArray): String {
        val hexChars = "0123456789abcdef".toCharArray()
        val result = StringBuilder(bytes.size * 2)
        
        for (b in bytes) {
            val i = b.toInt() and 0xFF
            result.append(hexChars[i shr 4])
            result.append(hexChars[i and 0x0F])
        }
        
        return result.toString()
    }
}
