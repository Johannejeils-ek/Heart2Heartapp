package com.example.heart2heartapp.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.heart2heartapp.ui.theme.PoppinsFont

@Composable
fun HeartCategoryButton(label: String) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.size(width = 86.dp, height = 80.dp)
    ) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            val w = size.width
            val h = size.height
            val path = Path().apply {
                moveTo(w / 2f, h * 0.85f)
                // venstre side
                cubicTo(
                    w * 0.10f, h * 0.65f,
                    w * 0.00f, h * 0.35f,
                    w * 0.25f, h * 0.20f
                )

                // venstre bule (top)
                cubicTo(
                    w * 0.40f, h * 0.15f,
                    w * 0.50f, h * 0.25f,
                    w / 2f, h * 0.28f
                )

                // højre bule (spejlet)

                cubicTo(
                    w * 0.50f, h * 0.20f,
                    w * 0.60f, h * 0.15f,
                    w * 0.75f, h * 0.20f
                )

                // højre side ned
                cubicTo(
                    w * 1.00f, h * 0.35f,
                    w * 0.90f, h * 0.65f,
                    w / 2f, h * 0.85f
                )
            }
            drawPath(path, Color(0xFFFF77B7))
        }
        Text(
            text = label,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontFamily = PoppinsFont,
            fontSize = 14.sp,
            modifier = Modifier.offset(y = 4.dp)
        )
    }
}