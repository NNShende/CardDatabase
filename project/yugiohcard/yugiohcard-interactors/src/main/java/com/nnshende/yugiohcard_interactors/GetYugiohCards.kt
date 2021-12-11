package com.nnshende.yugiohcard_interactors

import com.nnshende.core.domain.DataState
import com.nnshende.core.domain.ProgressBarState
import com.nnshende.core.domain.UIComponent
import com.nnshende.yugiohcard_datasource.cache.YugiohCardCache
import com.nnshende.yugiohcard_datasource.network.YugiohCardService
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
        pageSize: Int
    ): Flow<DataState<List<YugiohCard>>> = flow {
        try {
            emit(DataState.Loading(progressBarState = ProgressBarState.Loading))

            val yugiohCards: List<YugiohCard> = try { // catch network exceptions
                service.getCardList(
                    num = pageSize,
                    offset = (pageNumber - 1) * pageSize
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
                emptyList()
            }

            // caching
            cache.insert(yugiohCards)

            emit(
                DataState.Data(
                    if (yugiohCards.isNotEmpty()) yugiohCards
                    else cache.selectAll()
                )
            )
        } catch (e: Exception) {
            e.printStackTrace()
            emit(
                DataState.Response<List<YugiohCard>>(
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