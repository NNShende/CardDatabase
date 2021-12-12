package com.nnshende.yugiohcard_domain

data class ApiResponse(
    val data: List<YugiohCard>,
    val metaData: Metadata
)
