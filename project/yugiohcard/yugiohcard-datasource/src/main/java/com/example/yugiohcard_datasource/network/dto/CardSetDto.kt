package com.example.yugiohcard_datasource.network.dto

import com.example.yugiohcard_domain.CardSet
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CardSetDto(

    @SerialName("set_name")
    val setName: String,

    @SerialName("set_code")
    val setCode: String,

    @SerialName("set_rarity")
    val setRarity: String,

    @SerialName("set_rarity_code")
    val setRarityCode: String,

    @SerialName("set_price")
    val setPrice: Float,
)

fun CardSetDto.toCardSet(): CardSet {
    return CardSet(
        setName = setName,
        setCode = setCode,
        setRarity = setRarity,
        setRarityCode = setRarityCode,
        setPrice = setPrice
    )
}
