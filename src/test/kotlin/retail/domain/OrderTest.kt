package retail.domain

import org.junit.jupiter.api.Test
import java.math.BigDecimal
import kotlin.test.assertEquals

class OrderTest {
    val oneDollar = Price(BigDecimal.ONE)
    val tenDollars = Price(BigDecimal.TEN)

    @Test
    fun `should calculate order cost`() {
        val product = Product("Apple Pencil", tenDollars, 400)
        val product1 = Product("Some test product", oneDollar, 300)

        val order = Order(listOf(product, product1, product1))

        val result = order.totalCost()

        assertEquals(Price(BigDecimal("112.0")), result)
    }
}