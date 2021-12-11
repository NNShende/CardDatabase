package com.nnshende.yugiohcardsapp.ui.navigation

import androidx.navigation.NavType
import androidx.navigation.compose.NamedNavArgument
import androidx.navigation.compose.navArgument

sealed class Screen(
    val route: String,
    val arguments: List<NamedNavArgument>
) {
    object YugiohCardList: Screen(
        route = "yugiohcardList",
        arguments = emptyList()
    )

    object YugiohCardDetail: Screen(
        route = "yugiohcardDetail",
        arguments = listOf(
            navArgument("id") {
                type = NavType.IntType
            }
        )
    )
}
