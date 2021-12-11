package com.example.yugiohcard_datasource

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
