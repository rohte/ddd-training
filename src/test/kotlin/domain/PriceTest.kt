package domain

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.math.BigDecimal

class PriceTest {

    @Test
    fun `should calculate a discount of 10 percent`() {
        var price = Price(BigDecimal.TEN)

        var discount = price.getDiscount()

        assertEquals(discount, BigDecimal(9))
    }
}