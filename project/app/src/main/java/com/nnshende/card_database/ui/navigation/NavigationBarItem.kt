package com.nnshende.card_database.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector

sealed class NavigationBarItem(val route: String, val icon: ImageVector, val title: String) {
    object CardList: NavigationBarItem(
        route = Screen.YugiohCardList.route,
        icon = Icons.Filled.Home,
        title = "Home"
    )
}
