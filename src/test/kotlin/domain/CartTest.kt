package domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CartTest {

    @Test
    fun shouldAddProductToCart() {
        val cart = Cart()
        val product = Product("Some test product")
        cart.add(product, 1)
        val actual = cart.getProducts()
        assertEquals(1, actual.size)
        assertEquals("Some test product", actual[0].product.name)
        assertEquals(1, actual[0].quantity)
    }
}
