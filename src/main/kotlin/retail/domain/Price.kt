package retail.domain

import java.math.BigDecimal
import java.util.Currency

data class Price(val amount: BigDecimal, val currency: Currency = Currency.getInstance("USD")) {
    fun reduceByPercentage(percentage: BigDecimal): Price {
        val discount = this.amount.minus(this.amount.divide(percentage))
        return Price(discount)
    }

    infix operator fun plus(price: Price): Price {
        return price.copy(amount = price.amount + amount)
    }
}