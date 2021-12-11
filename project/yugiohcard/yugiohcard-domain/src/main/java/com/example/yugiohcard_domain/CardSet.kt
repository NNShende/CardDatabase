@file:Suppress("unused")
package com.example.yugiohcard_domain

data class CardSet(
    val setName: String,
    val setCode: String,
    val setRarity: String,
    val setRarityCode: String,
    val setPrice: Float,
)
