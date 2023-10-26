package retail.domain

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.math.BigDecimal

class PriceTest {

    @Test
    fun `should calculate a discount of 10 percent`() {
        val price = Price(BigDecimal.TEN)

        val discount = price.reduceByPercentage(BigDecimal.TEN)

        assertEquals(discount, Price(BigDecimal(9)))
    }

    @Test
    fun `should add two prices`() {
        val price1 = Price(BigDecimal.TEN)
        val price2 = Price(BigDecimal.ONE)

        val result = price1 + price2

        assertEquals(Price(BigDecimal(11)), result)
    }
}