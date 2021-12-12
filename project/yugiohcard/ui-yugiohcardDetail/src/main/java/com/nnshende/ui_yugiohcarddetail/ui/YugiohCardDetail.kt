package com.nnshende.ui_yugiohcarddetail.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.ImageLoader
import coil.compose.rememberImagePainter
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState
import com.nnshende.ui_yugiohcarddetail.R
import com.nnshende.yugiohcard_domain.getCardTypeRgb

@ExperimentalPagerApi
@Composable
fun YugiohCardDetail(
    state: YugiohCardDetailState,
    imageLoader: ImageLoader
) {
    state.card?.let { card ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
        ) {
            item {
                Column {
                    val pagerState = rememberPagerState()
                    HorizontalPager(count = card.cardImages.size, state = pagerState) { index ->
                        val image = card.cardImages[index].imageUrl
                        val painter = rememberImagePainter(
                            data = image,
                            imageLoader = imageLoader,
                            builder = {
                                placeholder(R.drawable.yugioh_back)
                            }
                        )
                        Image(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(450.dp)
                                .background(Color(getCardTypeRgb(card.type))),
                            painter = painter,
                            contentDescription = card.name,
                            contentScale = ContentScale.Fit,
                        )
                    }
                    if (card.cardImages.size > 1) {
                        HorizontalPagerIndicator(
                            pagerState = pagerState,
                            modifier = Modifier
                                .align(Alignment.CenterHorizontally)
                                .padding(top = 12.dp),
                        )
                    }
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(12.dp),
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = card.name,
                            textAlign = TextAlign.Left,
                            style = MaterialTheme.typography.h4,
                        )
                        Text(
                            text = card.desc,
                            textAlign = TextAlign.Left,
                            style = MaterialTheme.typography.body1
                        )
                    }
                }
            }
        }
    }
}