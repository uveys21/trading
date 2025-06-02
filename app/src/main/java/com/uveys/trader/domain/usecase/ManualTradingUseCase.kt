package com.uveys.trader.domain.usecase

import com.uveys.trader.domain.entity.Order
import com.uveys.trader.domain.entity.OrderSide
import com.uveys.trader.domain.entity.PositionSide
import com.uveys.trader.domain.repository.BinanceRepository
import java.math.BigDecimal
import javax.inject.Inject

/**
 * Manuel işlem yapmak için kullanılan use case
 */
class ManualTradingUseCase @Inject constructor(
    private val binanceRepository: BinanceRepository
) {
    
    /**
     * Manuel market emri oluşturur
     * @param symbol Kripto para çifti
     * @param side Emir yönü (BUY/SELL)
     * @param positionSide Pozisyon yönü (LONG/SHORT)
     * @param quantity Miktar
     * @return Oluşturulan emir
     */
    suspend fun createMarketOrder(
        symbol: String,
        side: OrderSide,
        positionSide: PositionSide,
        quantity: BigDecimal
    ): Order {
        return binanceRepository.createMarketOrder(symbol, side, positionSide, quantity)
    }
    
    /**
     * Manuel limit emri oluşturur
     * @param symbol Kripto para çifti
     * @param side Emir yönü (BUY/SELL)
     * @param positionSide Pozisyon yönü (LONG/SHORT)
     * @param price Fiyat
     * @param quantity Miktar
     * @return Oluşturulan emir
     */
    suspend fun createLimitOrder(
        symbol: String,
        side: OrderSide,
        positionSide: PositionSide,
        price: BigDecimal,
        quantity: BigDecimal
    ): Order {
        return binanceRepository.createLimitOrder(symbol, side, positionSide, price, quantity)
    }
    
    /**
     * Manuel stop-loss emri oluşturur
     * @param symbol Kripto para çifti
     * @param side Emir yönü (BUY/SELL)
     * @param positionSide Pozisyon yönü (LONG/SHORT)
     * @param stopPrice Tetiklenme fiyatı
     * @param quantity Miktar
     * @return Oluşturulan emir
     */
    suspend fun createStopLossOrder(
        symbol: String,
        side: OrderSide,
        positionSide: PositionSide,
        stopPrice: BigDecimal,
        quantity: BigDecimal
    ): Order {
        return binanceRepository.createStopLossOrder(symbol, side, positionSide, stopPrice, quantity)
    }
    
    /**
     * Manuel take-profit emri oluşturur
     * @param symbol Kripto para çifti
     * @param side Emir yönü (BUY/SELL)
     * @param positionSide Pozisyon yönü (LONG/SHORT)
     * @param price Tetiklenme fiyatı
     * @param quantity Miktar
     * @return Oluşturulan emir
     */
    suspend fun createTakeProfitOrder(
        symbol: String,
        side: OrderSide,
        positionSide: PositionSide,
        price: BigDecimal,
        quantity: BigDecimal
    ): Order {
        return binanceRepository.createTakeProfitOrder(symbol, side, positionSide, price, quantity)
    }
    
    /**
     * Kaldıraç oranını ayarlar
     * @param symbol Kripto para çifti
     * @param leverage Kaldıraç oranı
     * @return İşlem başarılı mı
     */
    suspend fun setLeverage(symbol: String, leverage: Int): Boolean {
        return binanceRepository.setLeverage(symbol, leverage)
    }

    /**
     * Manuel emir oluşturur. Price null ise market emri, değilse limit emir oluşturur.
     * @param symbol Kripto para çifti
     * @param side Emir yönü (BUY/SELL)
     * @param positionSide Pozisyon yönü (LONG/SHORT)
     * @param price Fiyat (null ise market emri)
     * @param quantity Miktar
     * @return Oluşturulan emir
     */
    suspend fun placeOrder(
        symbol: String,
        side: OrderSide,
        positionSide: PositionSide,
        price: BigDecimal?,
        quantity: BigDecimal
    ): Order {
        return if (price == null) {
            createMarketOrder(symbol, side, positionSide, quantity)
        } else {
            createLimitOrder(symbol, side, positionSide, price, quantity)
        }
    }
}
