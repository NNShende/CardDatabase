package com.nnshende.ui_yugiohcardlist.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
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
                state = state,
                onSearchChanged = {
                    onEvent(YugiohCardListEvent.UpdateSearchKeyword(it))
                },
                onExecuteSearch = {
                    onEvent(YugiohCardListEvent.GetYugiohCards(1))
                },
                onShowFilterDialog = {
                    // TODO
                }
            )
            Spacer(modifier = Modifier.padding(4.dp))
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