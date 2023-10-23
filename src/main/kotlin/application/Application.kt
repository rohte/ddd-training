package application

import domain.Cart
import domain.CartItem
import domain.Product


fun main(args: Array<String>) {
    val cart = Cart()
    val applePencil = Product("Apple Pencil")
    cart.add(applePencil, 2)
    val sonyHeadphone = Product("Sony Wireless headphone")
    cart.add(sonyHeadphone, 1)

    println("Cart = $cart")
    val products: List<CartItem> = cart.getProducts()

    println("----------------------------------------")
    println("products = $products")
    println("----------------------------------------")
}
