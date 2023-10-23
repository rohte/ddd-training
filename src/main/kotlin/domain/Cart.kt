package domain


class Cart {
    private val products: MutableList<Product> = ArrayList()

    fun add(product: Product) {
        products.add(product)
    }

    fun getProducts(): List<Product> {
        return products.toList()
    }

    override fun toString(): String {
        return "Cart{" +
                "products=" + products +
                '}'
    }
}
