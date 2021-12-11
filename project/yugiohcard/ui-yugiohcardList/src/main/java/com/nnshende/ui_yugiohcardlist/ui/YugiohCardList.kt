package com.nnshende.ui_yugiohcardlist.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import coil.ImageLoader
import com.nnshende.core.domain.ProgressBarState
import com.nnshende.ui_yugiohcardlist.components.YugiohCardListItem

@Composable
fun YugiohCardList(
    state: YugiohCardListState,
    imageLoader: ImageLoader,
    navigateToDetailScreen: (Int) -> Unit
) {
    val context = LocalContext.current
    Box(modifier = Modifier.fillMaxSize()) {
        if (state.progressBarState is ProgressBarState.Loading) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center)
            )
        }
        LazyColumn {
            items(state.cards) { card ->
                YugiohCardListItem(yugiohCard = card, imageLoader = imageLoader) { id ->
                    navigateToDetailScreen(id)
                }
            }
        }
    }
}