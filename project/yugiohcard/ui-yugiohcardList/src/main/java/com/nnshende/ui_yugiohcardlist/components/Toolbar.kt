package com.nnshende.ui_yugiohcardlist.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction.Companion.Search
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.nnshende.ui_yugiohcardlist.ui.YugiohCardListState
import com.nnshende.ui_yugiohcardlist.ui.test.TAG_YUGIOH_CARD_FILTER_BTN
import com.nnshende.ui_yugiohcardlist.ui.test.TAG_YUGIOH_CARD_SEARCH_BAR

@ExperimentalComposeUiApi
@Composable
fun Toolbar(
    state: YugiohCardListState,
    onSearchChanged: (String) -> Unit,
    onExecuteSearch: () -> Unit,
    onShowFilterDialog: () -> Unit,
) {
    val keyboardController = LocalSoftwareKeyboardController.current
    Surface(
        modifier = Modifier
            .fillMaxWidth(),
        color = MaterialTheme.colors.secondary,
        elevation = 12.dp,
    ) {
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                TextField(
                    modifier = Modifier
                        .fillMaxWidth(0.7f)
                        .padding(8.dp)
                        .testTag(TAG_YUGIOH_CARD_SEARCH_BAR),
                    value = state.searchKeyword,
                    onValueChange = {
                        onSearchChanged(it)
                    },
                    label = { Text(text = "Search") },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                        imeAction = Search,
                    ),
                    keyboardActions = KeyboardActions(
                        onDone = {
                            keyboardController?.hide()
                        },
                    ),
                    textStyle = TextStyle(color = MaterialTheme.colors.onSurface),
                    colors = TextFieldDefaults.textFieldColors(backgroundColor = MaterialTheme.colors.surface),
                )
                Button(
                    onClick = {
                        onExecuteSearch()
                    },
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                ) {
                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = "Search Button Icon",
                        tint = Color.White
                    )
                }
                Column(
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .clickable {
                            onShowFilterDialog()
                        }
                ) {
                    Icon(
                        modifier = Modifier
                            .padding(8.dp)
                            .testTag(TAG_YUGIOH_CARD_FILTER_BTN),
                        imageVector = Icons.Filled.MoreVert,
                        contentDescription = "Filter Icon"
                    )
                }
            }
            Row(
                modifier = Modifier.fillMaxWidth().padding(4.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(onClick = state.onFirstPageButtonClick, modifier = Modifier.width(50.dp)) {
                    Text(text = "<<")
                }
                Button(onClick = state.onPrevPageButtonClick, modifier = Modifier.width(50.dp)) {
                    Text(text = "<")
                }
                Text(text = "Page ${state.currentPage} / ${state.totalPages}")
                Button(onClick = state.onNextPageButtonClick, modifier = Modifier.width(50.dp)) {
                    Text(text = ">")
                }
                Button(onClick = state.onLastPageButtonClick, modifier = Modifier.width(50.dp)) {
                    Text(text = ">>")
                }
            }
        }
    }
}