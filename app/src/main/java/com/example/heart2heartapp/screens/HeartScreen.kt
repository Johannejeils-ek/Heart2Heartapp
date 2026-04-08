package com.example.heart2heartapp.screens

import androidx.compose.foundation.Image
import com.example.heart2heartapp.R
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.heart2heartapp.ui.theme.BricolageFont
import com.example.heart2heartapp.ui.theme.PoppinsFont


@Composable
fun HeartScreen(name: String, onArgumentsButtonClick: () -> Unit) {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFFFFF))
            .padding(
                top = 40.dp,
            ),
        horizontalAlignment = Alignment.CenterHorizontally,

    ) {
        Text(
            text = "Din Heart2Heart",
            fontSize = 45.sp,
            fontFamily = BricolageFont
        )
        Text(
            text = "nøglering er",
            fontSize = 45.sp,
            fontFamily = BricolageFont
        )
        Text(
            text = "connected",
            fontSize = 45.sp,
            fontFamily = BricolageFont
        )


        Column(
            modifier = Modifier
                .weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center

        ) {
            Image(
                painter = painterResource(R.drawable.heartscreen),
                contentDescription = "Heart screen image",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp),
                contentScale = ContentScale.Fit  // scales image to fit without cropping
            )
        }



        Button(
            onClick = onArgumentsButtonClick,
            modifier = Modifier
                .padding(bottom = 40.dp)
                .width(170.dp)
                .height(55.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFFF77B7),
                contentColor = Color.White
            )
        ) {
            Text(
                text = "Disconnect",
                fontSize = 16.sp,
                fontFamily = PoppinsFont
            )
        }


    }
}
