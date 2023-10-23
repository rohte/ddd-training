package application

import domain.Cart
import domain.Item
import domain.Product


fun main(args: Array<String>) {
    val cart = Cart()
    val applePencil = Product("Apple Pencil")
    cart.add(applePencil, 2)
    val sonyHeadphone = Product("Sony Wireless headphone")
    cart.add(sonyHeadphone, 1)

    cart.remove(applePencil)

    println("Cart = $cart")
    println("Removed items from cart = " + cart.getRemovedItems())
    val products: List<Item> = cart.getProducts()

    println("----------------------------------------")
    println("products = $products")
    println("----------------------------------------")
}
