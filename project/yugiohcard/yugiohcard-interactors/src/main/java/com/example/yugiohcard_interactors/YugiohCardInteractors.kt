package com.example.yugiohcard_interactors

import com.example.yugiohcard_datasource.network.YugiohCardService

data class YugiohCardInteractors(
    val getYugiohCards: GetYugiohCards,
    // TODO(Add other interactors)
) {
    companion object Factory {
        fun build(): YugiohCardInteractors{
            val service = YugiohCardService.build()
            return YugiohCardInteractors(
                getYugiohCards = GetYugiohCards(
                    service = service
                )
            )
        }
    }
}