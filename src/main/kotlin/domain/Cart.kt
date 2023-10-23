package domain


class Cart {
    private val products: MutableList<CartItem> = ArrayList()

    fun add(product: Product, quantity: Int) {
        products.add(CartItem(product,quantity))
    }

    fun getProducts(): List<CartItem> {
        return products.toList()
    }

    override fun toString(): String {
        return "Cart{" +
                "products=" + products +
                '}'
    }
}
