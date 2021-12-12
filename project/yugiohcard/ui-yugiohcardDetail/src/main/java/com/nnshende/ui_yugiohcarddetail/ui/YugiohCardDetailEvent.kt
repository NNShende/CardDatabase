package com.nnshende.ui_yugiohcarddetail.ui

sealed class YugiohCardDetailEvent {
    data class GetYugiohCardFromCache(
        val id: Int
    ): YugiohCardDetailEvent()
}
