package com.nnshende.ui_yugiohcardlist

import coil.ImageLoader
import com.nnshende.core.ProgressBarState
import com.nnshende.yugiohcard_domain.YugiohCard

data class YugiohCardListState(
    val progressBarState: ProgressBarState,
    val cards: List<YugiohCard> = listOf(),
    val imageLoader: ImageLoader
)
