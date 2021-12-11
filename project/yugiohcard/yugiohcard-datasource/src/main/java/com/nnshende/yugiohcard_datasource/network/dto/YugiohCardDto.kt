package com.nnshende.yugiohcard_datasource.network.dto

import com.nnshende.yugiohcard_domain.YugiohCard
import com.nnshende.yugiohcard_domain.getCardRace
import com.nnshende.yugiohcard_domain.getCardType
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class YugiohCardDto(

    @SerialName("id")
    val id: Int,

    @SerialName("name")
    val name: String,

    @SerialName("type")
    val type: String,

    @SerialName("desc")
    val desc: String,

    @SerialName("atk")
    val atk: Int? = null, // Non-null for monsters

    @SerialName("def")
    val def: Int? = null, // Non-null for monsters

    @SerialName("level")
    val level: Int?  = null, // Non-null for monsters

    @SerialName("race")
    val race: String,

    @SerialName("attribute")
    val attribute: String? = null, // Non-null for monsters

    @SerialName("card_sets")
    val cardSets: List<CardSetDto> = emptyList(),

    @SerialName("card_images")
    val cardImages: List<CardImageDto> = emptyList(),

    @SerialName("card_prices")
    val cardPrices: List<CardPriceDto> = emptyList(),
)

fun YugiohCardDto.toYugiohCard(): YugiohCard {
    return YugiohCard(
        id = id,
        name = name,
        type = getCardType(type),
        desc = desc,
        atk = atk,
        def = def,
        level = level,
        race = getCardRace(race),
        attribute = attribute,
        cardSets = cardSets.map { it.toCardSet() },
        cardImages = cardImages.map { it.toCardImage() },
        cardPrices = cardPrices.map { it.toCardPrice() }
    )
}