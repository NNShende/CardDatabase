package com.nnshende.yugiohcard_datasource.cache

import com.nnshende.yugiohcard_domain.CardImage
import com.nnshende.yugiohcard_domain.YugiohCard
import com.nnshende.yugiohcard_domain.getCardRace
import com.nnshende.yugiohcard_domain.getCardType
import com.nnshende.yugiohcarddatasource.cache.Yugiohcard_Entity

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
        cardImages = listOf(
            CardImage(
                id = id.toInt(),
                imageUrl = image_url ?: "", // image fetch will error and show placeholder
                imageUrlSmall = image_small_url ?: "" // image fetch will error and show placeholder
            )
        ),
        cardPrices = emptyList(),
    )
}