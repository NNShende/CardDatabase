package com.example.yugiohcard_datasource.network

import com.example.yugiohcard_datasource.network.dto.YugiohCardServiceImpl
import com.example.yugiohcard_domain.YugiohCard
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import kotlinx.serialization.json.Json

interface YugiohCardService {

    suspend fun getCardList(page: Int, pageSize: Int): List<YugiohCard>

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