package com.example.yugiohcard_datasource.network.dto

import com.example.yugiohcard_domain.CardImage
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CardImageDto(

    @SerialName("id")
    val id: Int,

    @SerialName("image_url")
    val imageUrl: String,

    @SerialName("image_url_small")
    val imageUrlSmall: String
)

fun CardImageDto.toCardImage(): CardImage {
    return CardImage(
        id = id,
        imageUrl = imageUrl,
        imageUrlSmall = imageUrlSmall
    )
}
