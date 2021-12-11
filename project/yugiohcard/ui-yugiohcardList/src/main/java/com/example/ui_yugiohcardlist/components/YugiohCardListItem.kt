package com.example.ui_yugiohcardlist

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
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.ui_yugiohcardlist.ui.test.TAG_YUGIOH_CARD_DESC
import com.example.ui_yugiohcardlist.ui.test.TAG_YUGIOH_CARD_NAME
import com.example.yugiohcard_domain.CardType
import com.example.yugiohcard_domain.YugiohCard

@Composable
fun YugiohCardListItem(
    yugiohCard: YugiohCard,
    onSelectItem: (Int) -> Unit,
    // imageLoader: ImageLoader, // TODO
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
            Box( // TODO(Replace with Image)
                modifier = Modifier
                    .width(100.dp)
                    .height(70.dp)
                    .background(Color.LightGray),
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth(.75f)
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
                Text(
                    modifier = Modifier
                        .testTag(TAG_YUGIOH_CARD_DESC),
                    text = yugiohCard.desc,
                    style = MaterialTheme.typography.subtitle2,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth() // Fill the rest of the width (100% - 80% = 20%)
                    .padding(end = 12.dp),
                horizontalAlignment = Alignment.End
            ) {
                Text(
                    text = yugiohCard.type.name,
                    style = MaterialTheme.typography.caption,
                    color = getCardTypeColor(yugiohCard.type),
                )
            }
        }
    }
}

private fun getCardTypeColor(type: CardType): Color {
    return when (type) {
        CardType.SpellCard -> Color(0xff008080)
        CardType.TrapCard -> Color(0xffcc6699)
        else -> Color(0xffcc4400)
    }
}
