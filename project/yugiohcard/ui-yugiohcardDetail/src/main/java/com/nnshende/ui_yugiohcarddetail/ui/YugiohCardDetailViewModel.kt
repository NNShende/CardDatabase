package com.nnshende.ui_yugiohcarddetail.ui

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nnshende.core.domain.DataState
import com.nnshende.core.domain.ProgressBarState
import com.nnshende.yugiohcard_interactors.GetYugiohCardFromCache
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class YugiohCardDetailViewModel @Inject constructor(
    private val getYugiohCardFromCache: GetYugiohCardFromCache,
    savedStateHandle: SavedStateHandle
): ViewModel() {

    val state: MutableState<YugiohCardDetailState> = mutableStateOf(YugiohCardDetailState())

    init {
        savedStateHandle.get<Int>("id")?.let { id ->
            onTriggerEvent(YugiohCardDetailEvent.GetYugiohCardFromCache(id))
        }
    }

    fun onTriggerEvent(event: YugiohCardDetailEvent) {
        when (event) {
            is YugiohCardDetailEvent.GetYugiohCardFromCache -> {
                getYugiohCardFromCache(event.id)
            }
        }
    }

    private fun getYugiohCardFromCache(id: Int) {
        getYugiohCardFromCache.execute(id).onEach { dataState ->
            when (dataState) {
                is DataState.Loading -> {
                    state.value = state.value.copy(progressBarState = dataState.progressBarState)
                }
                is DataState.Response -> {
                    // TODO(handle Error)
                }
                is DataState.Data -> {
                    state.value = state.value.copy(card = dataState.data)
                }
            }
        }.launchIn(viewModelScope)
    }
}