package domain

import java.util.UUID


class Cart {
    private val id: UUID = UUID.randomUUID()
    private val items: MutableList<Item> = ArrayList()
    private val removedItems: MutableList<Item> = ArrayList()

    fun add(product: Product, quantity: Int) {
        if (hasProduct(product)) {
            items.replaceAll {
                if (it.product == product) {
                    it.copy(quantity = it.quantity + quantity)
                } else it
            }
        } else {
            items.add(Item(product, quantity))
        }
    }

    private fun hasProduct(product: Product): Boolean {
        return items.any { it.product == product }
    }

    fun remove(product: Product) {
        items.find { it.product == product }?.let {
            items.remove(it)
            removedItems.add(it)
        }
    }

    fun items(): List<Item> {
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

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Cart

        return id == other.id
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }
}
