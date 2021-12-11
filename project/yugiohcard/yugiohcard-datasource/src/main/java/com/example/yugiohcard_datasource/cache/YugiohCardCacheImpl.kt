package com.example.yugiohcard_datasource.cache

import com.example.yugiohcard_domain.YugiohCard
import com.example.yugiohcarddatasource.cache.YugiohCardDBQueries

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