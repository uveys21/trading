package com.uveys.trader.test

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.uveys.trader.domain.entity.Position
import com.uveys.trader.domain.entity.PositionSide
import com.uveys.trader.presentation.ui.main.portfolio.PortfolioScreen
import com.uveys.trader.presentation.ui.theme.UveysTraderTheme
import org.junit.Rule
import org.junit.Test
import java.math.BigDecimal

class PortfolioScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testEmptyPositionsDisplaysMessage() {
        // Arrange
        composeTestRule.setContent {
            UveysTraderTheme {
                PortfolioScreen(
                    positions = emptyList(),
                    orderHistory = emptyList()
                )
            }
        }

        // Assert
        composeTestRule.onNodeWithText("Açık Pozisyonlar").assertIsDisplayed()
        composeTestRule.onNodeWithText("Açık pozisyon bulunmuyor").assertIsDisplayed()
    }

    @Test
    fun testPositionsTabDisplaysPositions() {
        // Arrange
        val testPositions = listOf(
            Position(
                symbol = "BTCUSDT",
                positionSide = PositionSide.LONG,
                entryPrice = BigDecimal("30000.00"),
                markPrice = BigDecimal("31000.00"),
                leverage = 10,
                unrealizedProfit = BigDecimal("100.00"),
                marginType = "isolated",
                isolatedMargin = BigDecimal("300.00"),
                positionAmt = BigDecimal("0.1"),
                updateTime = System.currentTimeMillis()
            )
        )

        composeTestRule.setContent {
            UveysTraderTheme {
                PortfolioScreen(
                    positions = testPositions,
                    orderHistory = emptyList()
                )
            }
        }

        // Assert
        composeTestRule.onNodeWithText("BTCUSDT").assertIsDisplayed()
        composeTestRule.onNodeWithText("LONG").assertIsDisplayed()
        composeTestRule.onNodeWithText("100.00 USDT").assertIsDisplayed()
    }

    @Test
    fun testTabSwitching() {
        // Arrange
        composeTestRule.setContent {
            UveysTraderTheme {
                PortfolioScreen(
                    positions = emptyList(),
                    orderHistory = emptyList()
                )
            }
        }

        // Act
        composeTestRule.onNodeWithText("İşlem Geçmişi").performClick()

        // Assert
        composeTestRule.onNodeWithText("İşlem geçmişi bulunmuyor").assertIsDisplayed()
    }
}
