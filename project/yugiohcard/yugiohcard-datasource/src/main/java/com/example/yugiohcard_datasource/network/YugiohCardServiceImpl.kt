package com.example.yugiohcard_datasource.network

import com.example.yugiohcard_datasource.network.dto.ApiResponseDto
import com.example.yugiohcard_datasource.network.dto.toYugiohCard
import com.example.yugiohcard_domain.YugiohCard
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.url

class YugiohCardServiceImpl(
    private val httpClient: HttpClient
) : YugiohCardService {

    override suspend fun getCardList(num: Int, offset: Int): List<YugiohCard> {
        return httpClient.get<ApiResponseDto>{
            url("${Endpoints.CARD_INFO}?num=$num&offset=$offset")
        }.data.map { it.toYugiohCard() }
    }
}