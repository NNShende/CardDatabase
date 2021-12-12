package com.nnshende.yugiohcard_datasource.network

import com.nnshende.yugiohcard_domain.YugiohCard
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import kotlinx.serialization.json.Json

interface YugiohCardService {

    suspend fun getCardList(num: Int, offset: Int, keyword: String): List<YugiohCard>

    companion object Factory {
        fun build(): YugiohCardService {
            return YugiohCardServiceImpl(
                httpClient = HttpClient(Android) {
                    install(JsonFeature) {
                        serializer = KotlinxSerializer(
                            Json {
                                ignoreUnknownKeys = true // protects from unknown fields
                            }
                        )
                    }
                }
            )
        }
    }
}