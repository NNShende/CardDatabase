package com.example.yugiohcard_interactors

import com.example.core.DataState
import com.example.core.ProgressBarState
import com.example.core.UIComponent
import com.example.yugiohcard_datasource.network.YugiohCardService
import com.example.yugiohcard_domain.YugiohCard
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetYugiohCards(
    private val service: YugiohCardService,
    // TODO(Add caching)
) {
    fun execute(
        pageNumber: Int,
        pageSize: Int
    ): Flow<DataState<List<YugiohCard>>> = flow {
        try {
            emit(DataState.Loading(progressBarState = ProgressBarState.Loading))

            delay(1000) // TODO(Delete)

            val yugiohCards: List<YugiohCard> = try { // catch network exceptions
                service.getCardList(
                    num = pageSize,
                    offset = pageNumber * pageSize
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
            // TODO(caching)
            emit(DataState.Data(yugiohCards))
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