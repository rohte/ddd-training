package domain;

import java.math.BigDecimal

class CompetitorBasedPricer {

    val competitorPrices:Map<String, Price> = mapOf(
        "Apple Pencil" to Price(BigDecimal(9)),
        "Sony Wireless headphone" to Price(BigDecimal("0.5")))
}
