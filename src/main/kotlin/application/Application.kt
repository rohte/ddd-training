package application

import domain.Cart
import domain.Item
import domain.Price
import domain.Product
import java.math.BigDecimal


fun main(args: Array<String>) {
    val cart = Cart()
    val applePencil = Product("Apple Pencil", Price(BigDecimal.TEN))
    cart.add(applePencil, 2)
    val sonyHeadphone = Product("Sony Wireless headphone", Price(BigDecimal.ONE))
    cart.add(sonyHeadphone, 1)

    cart.remove(applePencil)

    println("Cart = $cart")
    println("Removed items from cart = " + cart.getRemovedItems())
    val products: List<Item> = cart.items()

    println("----------------------------------------")
    println("products = $products")
    println("----------------------------------------")
}
