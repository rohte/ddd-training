package application

import retail.domain.*
import java.math.BigDecimal


fun main(args: Array<String>) {
    val cart = Cart()
    var competitorBasedPricer = CompetitorBasedPricer()
    val applePencil = Product("Apple Pencil", competitorBasedPricer.getPrice("Apple Pencil",Price(BigDecimal.TEN)))
    cart.add(applePencil, 2)
    val sonyHeadphone = Product("Sony Wireless headphone", competitorBasedPricer.getPrice("Sony Wireless headphone",Price(BigDecimal.ONE)))
    cart.add(sonyHeadphone, 3)

    cart.remove(applePencil)

    println("Cart = $cart")
    println("Removed items from cart = " + cart.getRemovedItems())
    val products: List<Item> = cart.items()

    println("----------------------------------------")
    println("products = $products")
    println("----------------------------------------")

    val order = OrderService().checkout(cart)

    println("Order: $order")

    println("----------------------------------------")
    println("products = ${order.products.joinToString("\n")}")
    println("----------------------------------------")

}
