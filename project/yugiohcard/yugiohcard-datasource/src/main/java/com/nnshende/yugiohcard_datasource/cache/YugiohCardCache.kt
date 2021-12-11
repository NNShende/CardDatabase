package com.nnshende.yugiohcard_datasource.cache

import com.nnshende.yugiohcard_domain.YugiohCard
import com.squareup.sqldelight.db.SqlDriver

interface YugiohCardCache {

    suspend fun get(id: Int): YugiohCard?

    suspend fun remove(id: Int)

    suspend fun selectAll(): List<YugiohCard>

    suspend fun insert(yugiohCard: YugiohCard)

    suspend fun insert(list: List<YugiohCard>)

    suspend fun searchByName(name: String): List<YugiohCard>

    companion object Factory {
        fun build(sqlDriver: SqlDriver): YugiohCardCache {
            return YugiohCardCacheImpl(YugiohCardDatabase(sqlDriver))
        }

        val schema: SqlDriver.Schema = YugiohCardDatabase.Schema

        val dbName = "yugiohcards.db"
    }
}