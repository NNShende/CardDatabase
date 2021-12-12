package com.nnshende.ui_yugiohcardlist.ui

import com.nnshende.core.domain.ProgressBarState
import com.nnshende.yugiohcard_domain.YugiohCard

data class YugiohCardListState(
    val progressBarState: ProgressBarState = ProgressBarState.Idle,
    val cards: List<YugiohCard> = listOf(),
    val searchKeyword: String = "",
)
