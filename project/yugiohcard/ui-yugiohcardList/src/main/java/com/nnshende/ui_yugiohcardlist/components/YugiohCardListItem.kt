package com.nnshende.ui_yugiohcardlist.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.ImageLoader
import coil.compose.rememberImagePainter
import com.nnshende.ui_yugiohcardlist.R
import com.nnshende.ui_yugiohcardlist.ui.test.TAG_YUGIOH_CARD_DESC
import com.nnshende.ui_yugiohcardlist.ui.test.TAG_YUGIOH_CARD_NAME
import com.nnshende.yugiohcard_domain.YugiohCard
import com.nnshende.yugiohcard_domain.getCardTypeRgb

@Composable
fun YugiohCardListItem(
    yugiohCard: YugiohCard,
    imageLoader: ImageLoader,
    onSelectItem: (Int) -> Unit,
){
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp)
            .background(MaterialTheme.colors.surface)
            .clickable {
                onSelectItem(yugiohCard.id)
            },
        elevation = 8.dp
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ){
            val image = if (yugiohCard.cardImages.isEmpty()) "" else yugiohCard.cardImages[0].imageUrlSmall
            val painter = rememberImagePainter(
                data = image,
                imageLoader = imageLoader,
                builder = {
                    placeholder(R.drawable.yugioh_back)
                }
            )
            Image(
                painter = painter,
                modifier = Modifier
                    .width(70.dp)
                    .height(100.dp)
                    .background(Color.LightGray),
                contentDescription = yugiohCard.name,
                contentScale = ContentScale.Fit
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 12.dp, end = 12.dp)
            ) {
                Text(
                    modifier = Modifier
                        .padding(bottom = 4.dp)
                        .testTag(TAG_YUGIOH_CARD_NAME),
                    text = yugiohCard.name,
                    style = MaterialTheme.typography.h4,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = yugiohCard.type.typeName,
                        color = Color(getCardTypeRgb(yugiohCard.type)),
                        style = MaterialTheme.typography.body1,
                    )
                    Text(
                        text = yugiohCard.race.raceName,
                        color = Color(getCardTypeRgb(yugiohCard.type)),
                        style = MaterialTheme.typography.body1,
                    )
                }
            }
        }
    }
}