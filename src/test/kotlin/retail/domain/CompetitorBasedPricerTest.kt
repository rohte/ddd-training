package retail.domain

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.math.BigDecimal

class CompetitorBasedPricerTest {

    @Test
    fun `should reduce the price below the competitor`() {
        var competitorBasedPricer = CompetitorBasedPricer()

        var discount = competitorBasedPricer.getPrice("Apple Pencil", Price(BigDecimal.TEN))

        assertEquals(Price(BigDecimal(9)), discount)
    }
}