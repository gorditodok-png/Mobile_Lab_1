package com.zeninlab

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.zeninlab.ui.theme.ForLab1Theme

@Composable
fun BusinessCardScreen() {
    // Здесь мы будем создавать UI визитной карточки.
    // Начнем с простого текста.
    Text(text = "Моя визитная карточка")
}

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    ForLab1Theme {
        BusinessCardScreen()
    }
}
