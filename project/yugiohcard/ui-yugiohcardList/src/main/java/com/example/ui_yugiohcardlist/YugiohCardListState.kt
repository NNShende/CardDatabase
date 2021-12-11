package com.example.ui_yugiohcardlist

import com.example.core.ProgressBarState
import com.example.yugiohcard_domain.YugiohCard

data class YugiohCardListState(
    val progressBarState: ProgressBarState,
    val cards: List<YugiohCard> = listOf()
)
