@file:Suppress("unused")
package com.nnshende.yugiohcard_domain

data class CardPrice(
    val cardMarketPrice: Float,
    val tcgPlayerPrice: Float,
    val ebayPrice: Float,
    val amazonPrice: Float,
    val coolStuffIncPrice: Float,
)
