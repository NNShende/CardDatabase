package com.example.yugiohcard_datasource.network.dto

import com.example.yugiohcard_datasource.network.Endpoints
import com.example.yugiohcard_datasource.network.YugiohCardService
import com.example.yugiohcard_domain.YugiohCard
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.url

class YugiohCardServiceImpl(
    private val httpClient: HttpClient
) : YugiohCardService {

    override suspend fun getCardList(page: Int, pageSize: Int): List<YugiohCard> {
        return httpClient.get<List<YugiohCardDto>>{
            url(Endpoints.CARD_INFO)
        }.map { it.toYugiohCard() }
    }
}