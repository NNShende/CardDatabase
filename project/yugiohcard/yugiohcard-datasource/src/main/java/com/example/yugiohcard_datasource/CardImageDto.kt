package com.example.yugiohcard_datasource

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
