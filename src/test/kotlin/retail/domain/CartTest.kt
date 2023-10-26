package retail.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.math.BigDecimal
import java.math.BigDecimal.ONE
import kotlin.test.assertFalse
import kotlin.test.assertNotEquals
import kotlin.test.assertTrue

class CartTest {

    private val oneDollar = Price(ONE)
    private val tenDollars = Price(BigDecimal.TEN)

    @Test
    fun `should add product to cart`() {
        val cart = Cart()
        val product = Product("Some test product", oneDollar, 100)
        cart.add(product, 1)
        val actual = cart.items()
        assertEquals(1, actual.size)
        assertEquals("Some test product", actual[0].product.name)
        assertEquals(1, actual[0].quantity)
    }

    @Test
    fun `should only add one item to cart`() {
        val cart = Cart()
        val product = Product("Some test product", oneDollar, 100)
        cart.add(product, 1)
        cart.add(product, 3)
        val actual = cart.items()
        assertEquals(1, actual.size)
        assertEquals("Some test product", actual[0].product.name)
        assertEquals(4, actual[0].quantity)
    }

    @Test
    fun `should remove product from cart`() {
        val cart = Cart()
        val product1 = Product("Some test product", oneDollar, 100)
        cart.add(product1, 2)
        val product2 = Product("Some other test product", oneDollar, 100)
        cart.add(product2, 3)

        cart.remove(product1)

        val actual = cart.items()
        assertEquals(1, actual.size)
        assertEquals("Some other test product", actual[0].product.name)
        assertEquals(3, actual[0].quantity)
    }

    @Test
    fun `should add removed product from cart to history of removed products`() {
        val cart = Cart()
        val product1 = Product("Some test product", oneDollar, 100)
        cart.add(product1, 2)
        val product2 = Product("Some other test product", tenDollars, 100)
        cart.add(product2, 3)

        cart.remove(product1)

        val actual = cart.getRemovedItems()
        assertEquals(1, actual.size)
        assertEquals("Some test product", actual[0].product.name)
        assertEquals(2, actual[0].quantity)
    }

    @Test
    fun `should recognise carts are different even with same content`() {
        val product = Product("Some test product", oneDollar, 100)
        val cart1 = Cart()
        cart1.add(product, 2)

        val cart2 = Cart()
        cart2.add(product, 2)

        assertNotEquals(cart1, cart2)
    }

    @Test
    fun `should check out a cart`() {
        val product = Product("Some test product", oneDollar, 100)
        val cart1 = Cart()
        cart1.add(product, 2)

        assertFalse(cart1.isCheckedOut)

        cart1.checkout()

        assertTrue(cart1.isCheckedOut)
    }
}
