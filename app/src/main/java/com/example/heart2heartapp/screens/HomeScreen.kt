package com.example.heart2heartapp.screens

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import com.example.heart2heartapp.R
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.heart2heartapp.classes.EventViewModel
import com.example.heart2heartapp.ui.theme.BricolageFont

@Composable
fun HomeScreen(name: String,
    onEventClick: (Int) -> Unit
) {

    val eventViewModel = viewModel<EventViewModel>()
    val events = eventViewModel.events
    val heartCategories = listOf("Sport", "Krea", "H2H", "Musik", "Mad")

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFFFFF)),
        contentPadding = PaddingValues(bottom = 16.dp)
    ) {


        // ── Hero Banner (first event) ──────────────────────────
        item {
            events.firstOrNull()?.let { heroEvent ->
                HeroBanner(
                    title = heroEvent.name,
                    onClick = { onEventClick(heroEvent.id) }
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
        }


        // ── Category Hearts ────────────────────────────────────
        item {
            Row(
                modifier = Modifier
                    .horizontalScroll(rememberScrollState())
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                heartCategories.forEach { label ->
                    HeartCategoryButton(label = label)
                }
            }
            Spacer(modifier = Modifier.height(24.dp))
        }


        // ── Udforsk events ─────────────────────────────────────
        item {
            Text(
                text = "Udforsk events",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF1A1A1A),
                modifier = Modifier.padding(start = 16.dp, bottom = 12.dp)
            )
            Row(
                modifier = Modifier
                    .horizontalScroll(rememberScrollState())
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                events.take(10).forEach { event ->
                    SmallEventCard(
                        title = event.name,
                        onClick = { onEventClick(event.id) }
                    )
                }
            }
            Spacer(modifier = Modifier.height(28.dp))
        }


        // ── Events udvalgt til dig ─────────────────────────────
        item {
            Text(
                text = "Events udvalgt til dig",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF1A1A1A),
                modifier = Modifier.padding(start = 16.dp, bottom = 12.dp)
            )
            Row(
                modifier = Modifier
                    .horizontalScroll(rememberScrollState())
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                events.drop(10).forEach { event ->
                    SmallEventCard(
                        title = event.name,
                        onClick = { onEventClick(event.id) }
                    )
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
        }

        // ── Full-width cards — one per event ───────────────────
        items(events.takeLast(2)) { event ->
            FullWidthEventCard(
                title = event.name,
                onClick = { onEventClick(event.id) }
            )
            Spacer(modifier = Modifier.height(14.dp))
        }
    }
}

// ── Hero Banner ───────────────────────────────────────────────
@Composable
fun HeroBanner(title: String, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 16.dp)
            .height(220.dp)
            .clip(RoundedCornerShape(16.dp))
            .clickable { onClick() }
    ) {
        Image(
            painter = painterResource(R.drawable.placeholder),
            contentDescription = title,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        listOf(Color.Transparent, Color(0x99000000))
                    )
                )
        )
        Text(
            text = title,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontFamily = BricolageFont,
            fontSize = 13.sp,
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(14.dp)
                .background(Color(0x80BFC1C2), RoundedCornerShape(20.dp))
                .padding(horizontal = 12.dp, vertical = 6.dp)
        )
    }
}

// ── Small Event Card ──────────────────────────────────────────
@Composable
fun SmallEventCard(title: String, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .size(140.dp)
            .clip(RoundedCornerShape(16.dp))
            .clickable { onClick() }
    ) {
        Image(
            painter = painterResource(R.drawable.placeholder),
            contentDescription = title,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        listOf(Color.Transparent, Color(0xAA000000))
                    )
                )
        )
        Text(
            text = title,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 13.sp,
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(10.dp)
        )
    }
}

// ── Full Width Event Card ─────────────────────────────────────
@Composable
fun FullWidthEventCard(title: String, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .height(200.dp)
            .clip(RoundedCornerShape(16.dp))
            .clickable { onClick() }
    ) {
        Image(
            painter = painterResource(R.drawable.placeholder),
            contentDescription = title,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        listOf(Color.Transparent, Color(0xAA000000))
                    )
                )
        )
        Text(
            text = title,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp,
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(14.dp)
                .background(Color(0x99000000), RoundedCornerShape(20.dp))
                .padding(horizontal = 12.dp, vertical = 6.dp)
        )
    }
}

// ── Heart Category Button ─────────────────────────────────────
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
            fontSize = 14.sp,
            modifier = Modifier.offset(y = 4.dp)
        )
    }
}