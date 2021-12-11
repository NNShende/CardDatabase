package com.example.yugiohcard_datasource

import com.example.yugiohcard_domain.*
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
    val attribute: String? = null,

    @SerialName("card_sets")
    val cardSets: List<CardSetDto> = emptyList(),

    @SerialName("card_images")
    val cardImages: List<CardImageDto> = emptyList(),

    @SerialName("card_prices")
    val cardPrices: List<CardPriceDto> = emptyList(),
)