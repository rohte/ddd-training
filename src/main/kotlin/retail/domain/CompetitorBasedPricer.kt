package retail.domain;

import java.math.BigDecimal

public class CompetitorBasedPricer {

    val competitorPrices:Map<String, Price> = mapOf(
        "Apple Pencil" to Price(BigDecimal(10)),
        "Sony Wireless headphone" to Price(BigDecimal("0.5"))
    )

    val discount: BigDecimal = BigDecimal.TEN

    fun getPrice(competitorProductName: String, originalPrice: Price): Price {
        val price = competitorPrices.get(competitorProductName)
        if (price != null) {
            return price.reduceByPercentage(discount)
        }
        return originalPrice
    }

}
