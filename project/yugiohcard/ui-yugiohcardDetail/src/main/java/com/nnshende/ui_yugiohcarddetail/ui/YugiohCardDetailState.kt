package com.nnshende.ui_yugiohcarddetail.ui

import com.nnshende.core.domain.ProgressBarState
import com.nnshende.yugiohcard_domain.YugiohCard

data class YugiohCardDetailState(
    val progressBarState: ProgressBarState = ProgressBarState.Idle,
    val card: YugiohCard? = null
)
