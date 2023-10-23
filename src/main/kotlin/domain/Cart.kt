package domain


class Cart {
    private val items: MutableList<Item> = ArrayList()

    fun add(product: Product, quantity: Int) {
        items.add(Item(product,quantity))
    }

    fun remove(product: Product) {
        items.removeIf { it.product == product }
    }

    fun getProducts(): List<Item> {
        return items.toList()
    }

    override fun toString(): String {
        return "Cart{" +
                "items=" + items +
                '}'
    }
}
