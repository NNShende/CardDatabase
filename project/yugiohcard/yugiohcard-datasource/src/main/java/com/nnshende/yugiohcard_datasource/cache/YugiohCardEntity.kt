package com.nnshende.yugiohcard_datasource.cache

import com.nnshende.yugiohcard_domain.CardImage
import com.nnshende.yugiohcard_domain.YugiohCard
import com.nnshende.yugiohcard_domain.getCardRace
import com.nnshende.yugiohcard_domain.getCardType
import com.nnshende.yugiohcarddatasource.cache.Yugiohcard_Entity

fun Yugiohcard_Entity.toYugiohCard(): YugiohCard {
    val cardImageList = cardImages(
        urlList = listOf(
            image_url_1,
            image_url_2,
            image_url_3,
            image_url_4,
            image_url_5,
            image_url_6,
            image_url_7,
            image_url_8,
            image_url_9
        ),
        thumbnailUrl = thumbnail_url,
        id = id.toInt()
    )


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
        cardImages = cardImageList,
        cardPrices = emptyList(),
    )
}

private fun cardImages(urlList: List<String?>, thumbnailUrl: String, id: Int): List<CardImage> {
    val cardImageList = mutableListOf<CardImage>()

    urlList.forEach { url ->
        url?.let {
            cardImageList.add(
                CardImage(
                    id = id,
                    imageUrl = url,
                    imageUrlSmall = thumbnailUrl
                )
            )
        }
    }

    return cardImageList
}