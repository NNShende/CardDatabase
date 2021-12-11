package com.nnshende.yugiohcard_interactors

import com.nnshende.core.domain.DataState
import com.nnshende.core.domain.ProgressBarState
import com.nnshende.core.domain.UIComponent
import com.nnshende.yugiohcard_datasource.cache.YugiohCardCache
import com.nnshende.yugiohcard_domain.YugiohCard
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetYugiohCardFromCache(
    private val cache: YugiohCardCache
) {
    fun execute(
        id: Int
    ): Flow<DataState<YugiohCard>> = flow {
        try {
            emit(DataState.Loading(progressBarState = ProgressBarState.Loading))

            val cachedCard = cache.get(id)

            if (cachedCard == null) {
                throw Exception("That card doesn't exist in the cache.")
            }

            emit(DataState.Data(cachedCard))
        } catch (e: Exception) {
            DataState.Response<YugiohCard>(
                uiComponent = UIComponent.Dialog(
                    title = "Error",
                    description =  e.message ?: "Unknown Error"
                )
            )
        }
        finally {
            emit(DataState.Loading(progressBarState = ProgressBarState.Idle))
        }
    }
}