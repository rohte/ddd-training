package retail.domain

import java.math.BigDecimal

data class Order(val products: List<Product>) {
    fun totalCost(): Price {
        return products.fold(Price(BigDecimal.ZERO)) { price, product ->
            price + product.price
        }.let {
            it.copy(amount = it.amount.add(shippingCost()))
        }
    }

    private fun shippingCost(): BigDecimal =
        BigDecimal(products.sumOf(Product::weightInGrams)).multiply(BigDecimal("0.1"))
}
