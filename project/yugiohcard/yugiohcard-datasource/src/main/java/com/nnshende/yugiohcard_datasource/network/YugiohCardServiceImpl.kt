package com.nnshende.yugiohcard_datasource.network

import com.nnshende.yugiohcard_datasource.network.dto.ApiResponseDto
import com.nnshende.yugiohcard_datasource.network.dto.toYugiohCard
import com.nnshende.yugiohcard_domain.YugiohCard
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.url

class YugiohCardServiceImpl(
    private val httpClient: HttpClient
) : YugiohCardService {

    override suspend fun getCardList(num: Int, offset: Int, keyword: String): List<YugiohCard> {
        return httpClient.get<ApiResponseDto>{
            url("${Endpoints.CARD_INFO}?num=$num&offset=$offset&fname=$keyword")
        }.data.map { it.toYugiohCard() }
    }
}