package com.nnshende.yugiohcard_datasource.network.dto

import com.nnshende.yugiohcard_domain.CardPrice
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CardPriceDto(

    @SerialName("cardmarket_price")
    val cardMarketPrice: Float,

    @SerialName("tcgplayer_price")
    val tcgPlayerPrice: Float,

    @SerialName("ebay_price")
    val ebayPrice: Float,

    @SerialName("amazon_price")
    val amazonPrice: Float,

    @SerialName("coolstuffinc_price")
    val coolStuffIncPrice: Float,
)

fun CardPriceDto.toCardPrice(): CardPrice {
    return CardPrice(
        cardMarketPrice = cardMarketPrice,
        tcgPlayerPrice = tcgPlayerPrice,
        ebayPrice = ebayPrice,
        amazonPrice = amazonPrice,
        coolStuffIncPrice = coolStuffIncPrice
    )
}
