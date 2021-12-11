package com.example.yugiohcard_datasource.cache

import com.example.yugiohcard_domain.YugiohCard
import com.example.yugiohcard_domain.getCardRace
import com.example.yugiohcard_domain.getCardType
import com.example.yugiohcarddatasource.cache.Yugiohcard_Entity

fun Yugiohcard_Entity.toYugiohCard(): YugiohCard {
    return YugiohCard(
        id = id.toInt(),
        name = name,
        type = getCardType(type),
        desc = desc,
        atk = atk?.toInt(),
        def = def?.toInt(),
        level = level?.toInt(),
        race = getCardRace(race),
        attribute = attribute,
        cardSets = emptyList(),
        cardImages = emptyList(),
        cardPrices = emptyList(),
    )
}