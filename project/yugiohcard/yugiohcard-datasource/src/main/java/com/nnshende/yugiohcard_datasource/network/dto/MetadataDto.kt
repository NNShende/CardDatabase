package com.nnshende.yugiohcard_datasource.network.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MetadataDto(

    @SerialName("current_rows")
    val currentRows: Int,

    @SerialName("total_rows")
    val totalRows: Int,

    @SerialName("rows_remaining")
    val rowsRemaining: Int,

    @SerialName("total_pages")
    val totalPages: Int,

    @SerialName("pages_remaining")
    val pagesRemaining: Int,

    @SerialName("previous_page")
    val previousPageUrl: String? = null,

    @SerialName("previous_page_offset")
    val previousPageOffset: Int? = null,

    @SerialName("next_page")
    val nextPageUrl: String? = null,

    @SerialName("next_page_offset")
    val nextPageOffset: Int? = null,
)