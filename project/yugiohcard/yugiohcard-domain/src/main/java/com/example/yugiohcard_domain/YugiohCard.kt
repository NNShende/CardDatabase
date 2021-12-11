@file:Suppress("unused")
package com.example.yugiohcard_domain

// API: https://db.ygoprodeck.com/api-guide/

data class YugiohCard(
    val id: Int,
    val name: String,
    val type: CardType,
    val desc: String,
    val atk: Int? = null, // Non-null for monsters
    val def: Int? = null, // Non-null for monsters
    val level: Int?  = null, // Non-null for monsters
    val race: CardRace,
    val attribute: String? = null,
    val cardSets: List<CardSet>,
    val cardImages: List<CardImage>,
    val cardPrices: List<CardPrice>,
)
