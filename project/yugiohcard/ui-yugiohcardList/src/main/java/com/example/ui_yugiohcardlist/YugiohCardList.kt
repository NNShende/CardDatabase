package com.example.ui_yugiohcardlist

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.example.core.ProgressBarState

@Composable
fun YugiohCardList(
    state: YugiohCardListState,
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
                YugiohCardListItem(card) { id ->
                    Toast.makeText(context, "ID: $id", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}