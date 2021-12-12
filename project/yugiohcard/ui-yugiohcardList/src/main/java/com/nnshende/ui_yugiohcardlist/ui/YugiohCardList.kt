package com.nnshende.ui_yugiohcardlist.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
    navigateToDetailScreen: (Int) -> Unit
) {
    Box(modifier = Modifier.fillMaxSize()) {
        Column {
            val searchKeyword = remember { mutableStateOf("") }
            Toolbar(
                searchKeyword = searchKeyword.value,
                onSearchChanged = {
                    searchKeyword.value = it
                },
                onExecuteSearch = {
                    // TODO
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