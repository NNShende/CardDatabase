package com.nnshende.yugiohcard_datasource.network

import com.nnshende.yugiohcard_datasource.network.dto.ApiResponseDto
import com.nnshende.yugiohcard_datasource.network.dto.toYugiohCard
import com.nnshende.yugiohcard_domain.ApiResponse
import com.nnshende.yugiohcard_domain.Metadata
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.url

typealias ApiMetadata = Metadata

class YugiohCardServiceImpl(
    private val httpClient: HttpClient
) : YugiohCardService {

    override suspend fun getCardList(num: Int, offset: Int, keyword: String): ApiResponse {
        val dto = httpClient.get<ApiResponseDto>{
            url("${Endpoints.CARD_INFO}?num=$num&offset=$offset&fname=$keyword")
        }
        return ApiResponse(
            data = dto.data.map { it.toYugiohCard() },
            metaData = ApiMetadata(
                currentRows = dto.metadata.currentRows,
                totalRows = dto.metadata.totalRows,
                rowsRemaining = dto.metadata.rowsRemaining,
                totalPages = dto.metadata.totalPages,
                pagesRemaining = dto.metadata.pagesRemaining,
                previousPageUrl = dto.metadata.previousPageUrl,
                previousPageOffset = dto.metadata.previousPageOffset,
                nextPageUrl = dto.metadata.nextPageUrl,
                nextPageOffset = dto.metadata.nextPageOffset,
            )
        )
    }
}