package com.nnshende.ui_yugiohcardlist.ui

import com.nnshende.core.domain.ProgressBarState
import com.nnshende.yugiohcard_domain.YugiohCard

data class YugiohCardListState(
    val progressBarState: ProgressBarState = ProgressBarState.Idle,
    val cards: List<YugiohCard> = listOf(),
    val searchKeyword: String = "",
    val currentPage: Int = 1,
    val totalPages: Int = 1,
    val prevPageButtonEnabled: Boolean = false,
    val onPrevPageButtonClick: () -> Unit = {},
    val nextPageButtonEnabled: Boolean = false,
    val onNextPageButtonClick: () -> Unit = {},
    val onFirstPageButtonClick: () -> Unit = {},
    val onLastPageButtonClick: () -> Unit = {},
)
