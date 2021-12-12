package com.nnshende.yugiohcard_domain

data class Metadata(
    val currentRows: Int,
    val totalRows: Int,
    val rowsRemaining: Int,
    val totalPages: Int,
    val pagesRemaining: Int,
    val previousPageUrl: String? = null,
    val previousPageOffset: Int? = null,
    val nextPageUrl: String? = null,
    val nextPageOffset: Int? = null,
)
