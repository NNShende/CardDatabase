package com.nnshende.ui_yugiohcardlist.ui

sealed class YugiohCardListEvent {
    object GetYugiohCards : YugiohCardListEvent()

    data class UpdateSearchKeyword(val newKeyword: String): YugiohCardListEvent()
}
