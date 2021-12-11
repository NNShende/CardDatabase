package com.example.yugiohcardsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.core.DataState
import com.example.core.Logger
import com.example.core.ProgressBarState
import com.example.core.UIComponent
import com.example.ui_yugiohcardlist.YugiohCardList
import com.example.ui_yugiohcardlist.YugiohCardListState
import com.example.yugiohcard_domain.YugiohCard
import com.example.yugiohcard_interactors.YugiohCardInteractors
import com.example.yugiohcardsapp.ui.theme.YugiohCardsAppTheme
import com.squareup.sqldelight.android.AndroidSqliteDriver
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class MainActivity : ComponentActivity() {

    private val yugiohCards: MutableState<List<YugiohCard>> = mutableStateOf(emptyList())

    private val progressBarState: MutableState<ProgressBarState> = mutableStateOf(ProgressBarState.Idle)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val getYugiohCards = YugiohCardInteractors.build(
            sqlDriver = AndroidSqliteDriver(
                schema = YugiohCardInteractors.schema,
                context = this,
                name = YugiohCardInteractors.dbName,
            )
        ).getYugiohCards
        val logger = Logger.Factory.buildDebug("Reeeeeeee")

        getYugiohCards.execute(1,25).onEach { dataState ->
            when (dataState) {
                is DataState.Response -> {
                    when (dataState.uiComponent) {
                        is UIComponent.Dialog -> {
                            logger.log((dataState.uiComponent as UIComponent.Dialog).description)
                        }
                        is UIComponent.None -> {
                            logger.log((dataState.uiComponent as UIComponent.None).message)
                        }
                    }
                }
                is DataState.Data -> {
                    yugiohCards.value = dataState.data ?: emptyList()
                    dataState.data?.forEach {
                        logger.log(it.name)
                    }
                }
                is DataState.Loading -> {
                    progressBarState.value = dataState.progressBarState
                }
            }
        }.launchIn(CoroutineScope(IO))

        setContent {
            YugiohCardsAppTheme {
                YugiohCardList(
                    state = YugiohCardListState(
                        progressBarState = progressBarState.value,
                        cards = yugiohCards.value
                    )
                )
            }
        }
    }
}
