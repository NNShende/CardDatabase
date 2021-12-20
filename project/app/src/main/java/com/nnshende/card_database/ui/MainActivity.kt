package com.nnshende.card_database.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import coil.ImageLoader
import com.google.accompanist.pager.ExperimentalPagerApi
import com.nnshende.ui_yugiohcarddetail.ui.YugiohCardDetail
import com.nnshende.ui_yugiohcarddetail.ui.YugiohCardDetailViewModel
import com.nnshende.ui_yugiohcardlist.ui.YugiohCardList
import com.nnshende.ui_yugiohcardlist.ui.YugiohCardListViewModel
import com.nnshende.card_database.R
import com.nnshende.card_database.ui.navigation.NavigationBarItem
import com.nnshende.card_database.ui.navigation.Screen
import com.nnshende.card_database.ui.theme.YugiohCardsAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var imageLoader: ImageLoader

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        imageLoader = ImageLoader.Builder(applicationContext)
            .error(R.drawable.yugioh_back)
            .placeholder(R.drawable.yugioh_back)
            .availableMemoryPercentage(0.25)
            .crossfade(true)
            .build()

        setContent {
            MainScreen()
        }
    }


    @Composable
    private fun MainScreen() {
        val navController = rememberNavController()
        YugiohCardsAppTheme {
            Scaffold(
                topBar = {},
                bottomBar = { BottomNavBar(navController = navController) }
            ) {
                Navigation(navController = navController)
            }
        }
    }

    @Composable
    private fun Navigation(navController: NavHostController) {
        NavHost(
            navController = navController,
            startDestination = NavigationBarItem.CardList.route,
            modifier = Modifier.fillMaxHeight(CONTENT_HEIGHT),
            builder = {
                addYugiohCardList(navController = navController)
                addYugiohCardDetail()
            }
        )
    }

    @Composable
    private fun BottomNavBar(navController: NavController) {
        val items = listOf(
            NavigationBarItem.CardList
        )
        BottomNavigation(
            backgroundColor = Color.White,
            contentColor = Color.Black,
            modifier = Modifier.fillMaxHeight(NAV_BAR_HEIGHT),
            elevation = 2.dp
        ) {
            val navBackStackEntry = navController.currentBackStackEntry
            val currentRoute = navBackStackEntry?.destination?.route
            items.forEach { item ->
                BottomNavigationItem(
                    icon = {
                        Image(
                            imageVector = item.icon,
                            contentDescription = "Nav: ${item.title}"
                        )
                    },
                    label = { Text(text = item.title) },
                    selected = currentRoute == item.route,
                    selectedContentColor = Color.Black,
                    unselectedContentColor = Color.Gray,
                    alwaysShowLabel = true,
                    onClick = {
                        navController.navigate(item.route) {
                            navController.graph.startDestinationRoute?.let { routeName ->
                                popUpTo(routeName) { saveState = true }
                            }

                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                )
            }
        }
    }


    @OptIn(ExperimentalComposeUiApi::class)
    fun NavGraphBuilder.addYugiohCardList(
        navController: NavController,
    ) {
        composable(
            route = Screen.YugiohCardList.route
        ) {
            val viewModel: YugiohCardListViewModel = hiltViewModel()
            YugiohCardList(
                state = viewModel.state.value,
                imageLoader = imageLoader,
                onEvent = viewModel::onTriggerEvent,
                navigateToDetailScreen = { id ->
                    navController.navigate("${Screen.YugiohCardDetail.route}/$id")
                }
            )
        }
    }

    @OptIn(ExperimentalPagerApi::class)
    fun NavGraphBuilder.addYugiohCardDetail() {
        composable(
            route = Screen.YugiohCardDetail.route + "/{id}",
            arguments = Screen.YugiohCardDetail.arguments
        ) {
            val viewModel: YugiohCardDetailViewModel = hiltViewModel()
            YugiohCardDetail(state = viewModel.state.value, imageLoader = imageLoader)
        }
    }

    companion object {
        const val NAV_BAR_HEIGHT = 0.075f
        const val CONTENT_HEIGHT = 1f - NAV_BAR_HEIGHT
    }
}
