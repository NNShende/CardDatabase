package com.example.yugiohcard_datasource.network.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ApiResponseDto(

    @SerialName("data")
    val data: List<YugiohCardDto>,

    @SerialName("meta")
    val metadata: MetadataDto
)