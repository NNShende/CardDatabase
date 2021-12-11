package com.nnshende.ui_yugiohcarddetail

import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun YugiohCardDetail(
    id: Int?
) {
    Text(text = "ID: $id")
}