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

    init {
        getYugiohCards()
    }

    private fun getYugiohCards() {
        getYugiohCards.execute(1,25).onEach { dataState ->
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
                    state.value = state.value.copy(cards = dataState.data ?: emptyList())
                }
                is DataState.Loading -> {
                    state.value = state.value.copy(progressBarState = dataState.progressBarState)
                }
            }
        }.launchIn(viewModelScope)
    }

}