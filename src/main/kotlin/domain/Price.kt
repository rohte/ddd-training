package domain

import java.math.BigDecimal
import java.util.Currency

data class Price(val amount: BigDecimal, val currency: Currency = Currency.getInstance("USD")) {
    fun getDiscount(): BigDecimal {
        return this.amount.minus(this.amount.divide(BigDecimal.TEN))
    }
}