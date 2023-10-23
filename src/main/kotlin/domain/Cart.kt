package domain


class Cart {
    private val items: MutableList<Item> = ArrayList()
    private val removedItems: MutableList<Item> = ArrayList()

    fun add(product: Product, quantity: Int) {
        items.add(Item(product,quantity))
    }

    fun remove(product: Product) {
        items.find { it.product == product }?.let {
            items.remove(it)
            removedItems.add(it)
        }
    }

    fun getProducts(): List<Item> {
        return items.toList()
    }

    fun getRemovedItems(): List<Item> {
        return removedItems.toList()
    }

    override fun toString(): String {
        return "Cart{" +
                "items=" + items +
                '}'
    }
}
