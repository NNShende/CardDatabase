package com.nnshende.ui_yugiohcardlist.ui

sealed class YugiohCardListEvent {
    data class GetYugiohCards(val pageNumber: Int) : YugiohCardListEvent()

    data class UpdateSearchKeyword(val newKeyword: String): YugiohCardListEvent()
}
