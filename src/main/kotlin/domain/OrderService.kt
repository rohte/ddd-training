package domain

class OrderService {

    fun checkout(cart: Cart): Order {
        cart.checkout()
        return cart.items()
            .flatMap { item ->
                List(item.quantity) { item.product }
            }.let { Order(it) }
    }
}