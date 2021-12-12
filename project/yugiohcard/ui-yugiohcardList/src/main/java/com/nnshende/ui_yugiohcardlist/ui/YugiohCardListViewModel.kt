package com.nnshende.ui_yugiohcardlist.ui

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nnshende.core.domain.DataState
import com.nnshende.core.domain.UIComponent
import com.nnshende.core.util.Logger
import com.nnshende.yugiohcard_interactors.GetYugiohCards
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class YugiohCardListViewModel @Inject constructor(
    private val getYugiohCards: GetYugiohCards
): ViewModel() {

    private val logger: Logger = Logger.buildDebug(TAG = "YugiohCardListViewModel")

    val state: MutableState<YugiohCardListState> = mutableStateOf(YugiohCardListState())
    private val pageSize = 25

    init {
        onTriggerEvent(YugiohCardListEvent.GetYugiohCards(state.value.currentPage))
    }

    fun onTriggerEvent(event: YugiohCardListEvent) {
        logger.log("Event Received: $event")
        when (event) {
            is YugiohCardListEvent.GetYugiohCards -> {
                state.value = state.value.copy(currentPage = event.pageNumber)
                getYugiohCards()
            }
            is YugiohCardListEvent.UpdateSearchKeyword -> {
                updateSearchKeyword(newKeyword = event.newKeyword)
            }
        }
    }

    private fun getYugiohCards() {
        logger.log("Fetching Data with params { pageNumber: ${state.value.currentPage}, pageSize: $pageSize, keyword: '${state.value.searchKeyword}' }")
        getYugiohCards.execute(
            pageNumber = state.value.currentPage,
            pageSize = pageSize,
            keyword = state.value.searchKeyword
        ).onEach { dataState ->
            when (dataState) {
                is DataState.Response -> {
                    when (dataState.uiComponent) {
                        is UIComponent.Dialog -> {
                            logger.log((dataState.uiComponent as UIComponent.Dialog).description)
                        }
                        is UIComponent.None -> {
                            logger.log((dataState.uiComponent as UIComponent.None).message)
                        }
                    }
                }
                is DataState.Data -> {
                    // Data related ops
                    val cardList = dataState.data?.data ?: emptyList()

                    // Metadata related ops
                    val currentPage = state.value.currentPage
                    val metadata = dataState.data?.metaData
                    val prevPageExists = metadata?.previousPageOffset != null
                    val prevPageLambda = { onTriggerEvent(YugiohCardListEvent.GetYugiohCards(currentPage - 1)) }
                    val nextPageExists = metadata?.nextPageOffset != null
                    val nextPageLambda = { onTriggerEvent(YugiohCardListEvent.GetYugiohCards(currentPage + 1)) }
                    state.value = state.value.copy(
                        cards = cardList,
                        prevPageButtonEnabled = prevPageExists,
                        onPrevPageButtonClick = if (!prevPageExists) {{}} else {prevPageLambda},
                        nextPageButtonEnabled = nextPageExists,
                        onNextPageButtonClick = if (!nextPageExists) {{}} else {nextPageLambda},
                    )
                }
                is DataState.Loading -> {
                    state.value = state.value.copy(progressBarState = dataState.progressBarState)
                }
            }
        }.launchIn(viewModelScope)
    }

    private fun updateSearchKeyword(newKeyword: String) {
        state.value = state.value.copy(searchKeyword = newKeyword)
    }

}