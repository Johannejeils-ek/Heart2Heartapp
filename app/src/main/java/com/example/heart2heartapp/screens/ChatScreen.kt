package com.example.heart2heartapp.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.heart2heartapp.ui.theme.BricolageFont
import com.example.heart2heartapp.ui.theme.PoppinsFont

@Composable
fun ChatScreen () {
    Column {
        header(BricolageFont)
        listOfMessages(PoppinsFont)
    }
}

@Composable
fun header (fontFamily: FontFamily){
    Text(
        "Beskeder",
        color = Color(0xFFFF77B7),
        fontSize = 50.sp,
        fontFamily = BricolageFont,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 40.dp)
            .padding(horizontal = 20.dp)

    )
}


@Composable
fun listOfMessages(fontFamily: FontFamily) {

    val navne = listOf(
        "Grethe",
        "Andrea",
        "Laura",
        "Natalie",
        "Pia",
        "Stine",
        "Johanne",
        "Alberte",
        "Nanna",
        "Mathilde",
        "Benedicte",
        "Hanne",
        "Signe",
        "Sofie"
    )

    LazyColumn {
        items(navne) { navn ->
            Text(
                text = navn,
                fontSize = 30.sp,
                fontFamily = PoppinsFont,
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 24.dp)
                    .padding(horizontal = 24.dp)
            )
        }
    }
}

