package retail.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import java.math.BigDecimal

class OrderServiceTest {
    val oneDollar = Price(BigDecimal.ONE)
    val tenDollars = Price(BigDecimal.TEN)

    @Test
    fun `should create simple order`() {
        val product = Product("Apple Pencil", Price(BigDecimal.TEN))
        val cart = Cart()
        cart.add(product, 1)

        val order = OrderService().checkout(cart)

        assertEquals(Order(listOf(product)), order)
        assertTrue(cart.isCheckedOut)
    }

    @Test
    fun `should create order with multiple items`() {
        val product = Product("Apple Pencil", tenDollars)
        val product1 = Product("Some test product", oneDollar)
        val cart = Cart()
        cart.add(product, 2)
        cart.add(product1, 3)

        val order = OrderService().checkout(cart)

        assertEquals(Order(listOf(product, product, product1, product1, product1)), order)
        assertTrue(cart.isCheckedOut)
    }
}
