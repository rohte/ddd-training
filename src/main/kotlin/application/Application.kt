package application

import domain.Cart
import domain.Product


fun main(args: Array<String>) {
    val cart = Cart()
    val product = Product("Apple Pencil")
    cart.add(product)
    val sonyHeadphone = Product("Sony Wireless headphone")
    cart.add(sonyHeadphone)

    println("Cart = $cart")
    val products: List<Product> = cart.getProducts()

    println("----------------------------------------")
    println("products = $products")
    println("----------------------------------------")
}
