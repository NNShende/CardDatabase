package com.nnshende.yugiohcardsapp.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import coil.ImageLoader
import com.nnshende.ui_yugiohcarddetail.YugiohCardDetail
import com.nnshende.ui_yugiohcardlist.ui.YugiohCardList
import com.nnshende.ui_yugiohcardlist.ui.YugiohCardListViewModel
import com.nnshende.yugiohcardsapp.R
import com.nnshende.yugiohcardsapp.ui.navigation.Screen
import com.nnshende.yugiohcardsapp.ui.theme.YugiohCardsAppTheme
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
            val navController = rememberNavController()
            YugiohCardsAppTheme {

                NavHost(
                    navController = navController,
                    startDestination = Screen.YugiohCardList.route,
                    builder = {
                        addYugiohCardList(navController = navController, imageLoader = imageLoader)
                        addYugiohCardDetail()
                    }
                )
            }
        }
    }
}

fun NavGraphBuilder.addYugiohCardList(
    navController: NavController,
    imageLoader: ImageLoader
) {
    composable(
        route = Screen.YugiohCardList.route
    ) {
        val viewModel: YugiohCardListViewModel = hiltViewModel()
        YugiohCardList(
            state = viewModel.state.value,
            imageLoader = imageLoader,
            navigateToDetailScreen = { id ->
                navController.navigate("${Screen.YugiohCardDetail.route}/$id")
            }
        )
    }
}

fun NavGraphBuilder.addYugiohCardDetail() {
    composable(
        route = Screen.YugiohCardDetail.route + "/{id}",
        arguments = Screen.YugiohCardDetail.arguments
    ) {
        YugiohCardDetail(id = it.arguments?.get("id") as Int?)
    }
}
