package com.example.yugiohcard_interactors

import com.example.yugiohcard_datasource.cache.YugiohCardCache
import com.example.yugiohcard_datasource.network.YugiohCardService
import com.squareup.sqldelight.db.SqlDriver

data class YugiohCardInteractors(
    val getYugiohCards: GetYugiohCards,
    // TODO(Add other interactors)
) {
    companion object Factory {
        fun build(sqlDriver: SqlDriver): YugiohCardInteractors{
            val service = YugiohCardService.build()
            val cache = YugiohCardCache.build(sqlDriver)
            return YugiohCardInteractors(
                getYugiohCards = GetYugiohCards(
                    service = service,
                    cache = cache
                )
            )
        }

        val schema: SqlDriver.Schema = YugiohCardCache.schema

        val dbName: String = YugiohCardCache.dbName
    }
}