package retail.domain

import retail.domain.events.CartCheckedOutEvent
import retail.domain.events.DomainEvent
import retail.domain.events.ItemAddedToCartEvent
import retail.domain.events.ItemRemovedFromCartEvent
import java.util.UUID


class Cart {
    private val id: UUID = UUID.randomUUID()
    private val items: MutableList<Item> = ArrayList()
    private val history: MutableList<DomainEvent> = ArrayList()

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
        history.add(ItemAddedToCartEvent(Item(product, quantity)))
    }

    private fun hasProduct(product: Product): Boolean {
        return items.any { it.product == product }
    }

    fun remove(product: Product) {
        items.find { it.product == product }?.let {
            items.remove(it)
            history.add(ItemRemovedFromCartEvent(it))
        }
    }

    fun items(): List<Item> {
        return items.toList()
    }

    fun getRemovedItems(): List<Item> {
        return history
            .filterIsInstance<ItemRemovedFromCartEvent>()
            .map { it.item }
    }

    fun checkout() {
        history.add(CartCheckedOutEvent())
    }

    val isCheckedOut: Boolean get() {
        return history.any { it is CartCheckedOutEvent }
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
