package com.nnshende.yugiohcard_datasource.cache

import com.nnshende.yugiohcard_domain.YugiohCard
import com.nnshende.yugiohcarddatasource.cache.YugiohCardDBQueries

class YugiohCardCacheImpl(
    private val database: YugiohCardDatabase
) : YugiohCardCache {
    private var queries: YugiohCardDBQueries = database.yugiohCardDBQueries

    override suspend fun get(id: Int): YugiohCard {
        return queries.getYugiohCard(id.toLong()).executeAsOne().toYugiohCard()
    }

    override suspend fun remove(id: Int) {
        queries.removeYugiohCard(id.toLong())
    }

    override suspend fun selectAll(): List<YugiohCard> {
        return queries.selectAll().executeAsList().map { it.toYugiohCard() }
    }

    override suspend fun insert(yugiohCard: YugiohCard) {
        with(yugiohCard) {

            queries.insertYugiohCard(
                id = id.toLong(),
                name = name,
                type = type.typeName,
                desc = desc,
                atk = atk?.toLong(),
                def = def?.toLong(),
                level = level?.toLong(),
                race = race.raceName,
                attribute = attribute,
                thumbnail_url = cardImages[0].imageUrlSmall,
                image_url_1 = cardImages[0].imageUrl,
                image_url_2 = if (cardImages.size >= 2) cardImages[1].imageUrl else null,
                image_url_3 = if (cardImages.size >= 3) cardImages[2].imageUrl else null,
                image_url_4 = if (cardImages.size >= 4) cardImages[3].imageUrl else null,
                image_url_5 = if (cardImages.size >= 5) cardImages[4].imageUrl else null,
                image_url_6 = if (cardImages.size >= 6) cardImages[5].imageUrl else null,
                image_url_7 = if (cardImages.size >= 7) cardImages[6].imageUrl else null,
                image_url_8 = if (cardImages.size >= 8) cardImages[7].imageUrl else null,
                image_url_9 = if (cardImages.size >= 9) cardImages[8].imageUrl else null,
            )
        }
    }

    override suspend fun insert(list: List<YugiohCard>) {
        list.forEach {
            try {
                insert(it)
            } catch (e: Exception) {
                e.printStackTrace()
                // if one has an error just continue with others
            }
        }
    }

    override suspend fun searchByName(name: String): List<YugiohCard> {
        return queries.searchYugiohCardByName(name).executeAsList().map { it.toYugiohCard() }
    }
}