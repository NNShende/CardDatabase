package com.nnshende.yugiohcard_interactors

import com.nnshende.core.domain.DataState
import com.nnshende.core.domain.ProgressBarState
import com.nnshende.core.domain.UIComponent
import com.nnshende.yugiohcard_datasource.cache.YugiohCardCache
import com.nnshende.yugiohcard_datasource.network.YugiohCardService
import com.nnshende.yugiohcard_domain.ApiResponse
import com.nnshende.yugiohcard_domain.YugiohCard
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetYugiohCards(
    private val cache: YugiohCardCache,
    private val service: YugiohCardService,
) {
    fun execute(
        pageNumber: Int,
        pageSize: Int,
        keyword: String,
    ): Flow<DataState<ApiResponse>> = flow {
        try {
            emit(DataState.Loading(progressBarState = ProgressBarState.Loading))

            val apiResponse: ApiResponse? = try { // catch network exceptions
                service.getCardList(
                    num = pageSize,
                    offset = (pageNumber - 1) * pageSize,
                    keyword = keyword
                )
            } catch (e: Exception) {
                e.printStackTrace()
                emit(
                    DataState.Response(
                        uiComponent = UIComponent.Dialog(
                            title = "Network Error",
                            description =  e.message ?: "Unknown Error"
                        )
                    )
                )
                null
            }

            val yugiohCards = apiResponse?.data ?: throw Exception("No results found")

            // caching
            cache.insert(yugiohCards)

            // TODO(implement a cached API response)

            emit(DataState.Data(data = apiResponse))
        } catch (e: Exception) {
            e.printStackTrace()
            emit(
                DataState.Response<ApiResponse>(
                    uiComponent = UIComponent.Dialog(
                        title = "Error",
                        description =  e.message ?: "Unknown Error"
                    )
                )
            )
        }
        finally {
            emit(DataState.Loading(progressBarState = ProgressBarState.Idle))
        }
    }
}