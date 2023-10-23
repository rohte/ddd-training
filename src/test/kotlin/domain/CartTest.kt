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

    @Test
    fun `should remove product from cart`() {
        val cart = Cart()
        val product1 = Product("Some test product")
        cart.add(product1, 2)
        val product2 = Product("Some other test product")
        cart.add(product2, 3)

        cart.remove(product1)

        val actual = cart.getProducts()
        assertEquals(1, actual.size)
        assertEquals("Some other test product", actual[0].product.name)
        assertEquals(3, actual[0].quantity)
    }

    @Test
    fun `should add removed product from cart to history of removed products`() {
        val cart = Cart()
        val product1 = Product("Some test product")
        cart.add(product1, 2)
        val product2 = Product("Some other test product")
        cart.add(product2, 3)

        cart.remove(product1)

        val actual = cart.getRemovedItems()
        assertEquals(1, actual.size)
        assertEquals("Some test product", actual[0].product.name)
        assertEquals(2, actual[0].quantity)
    }
}
