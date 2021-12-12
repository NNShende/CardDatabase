package com.nnshende.ui_yugiohcardlist.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import coil.ImageLoader
import com.nnshende.core.domain.ProgressBarState
import com.nnshende.ui_yugiohcardlist.components.Toolbar
import com.nnshende.ui_yugiohcardlist.components.YugiohCardListItem

@ExperimentalComposeUiApi
@Composable
fun YugiohCardList(
    state: YugiohCardListState,
    imageLoader: ImageLoader,
    onEvent: (YugiohCardListEvent) -> Unit,
    navigateToDetailScreen: (Int) -> Unit
) {
    Box(modifier = Modifier.fillMaxSize()) {
        Column {
            Toolbar(
                searchKeyword = state.searchKeyword,
                onSearchChanged = {
                    onEvent(YugiohCardListEvent.UpdateSearchKeyword(it))
                },
                onExecuteSearch = {
                    onEvent(YugiohCardListEvent.GetYugiohCards)
                },
                onShowFilterDialog = {
                    // TODO
                }
            )
            LazyColumn {
                items(state.cards) { card ->
                    YugiohCardListItem(yugiohCard = card, imageLoader = imageLoader) { id ->
                        navigateToDetailScreen(id)
                    }
                }
            }
        }
        if (state.progressBarState is ProgressBarState.Loading) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}