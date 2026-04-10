package com.example.heart2heartapp.screens

import androidx.compose.foundation.Image
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.heart2heartapp.classes.Event
import com.example.heart2heartapp.classes.viewModel.EventViewModel
import com.example.heart2heartapp.components.FullWidthEventCard
import com.example.heart2heartapp.components.HeartCategoryButton
import com.example.heart2heartapp.components.HeroBanner
import com.example.heart2heartapp.components.SmallEventCard
import com.example.heart2heartapp.ui.theme.BricolageFont
import com.example.heart2heartapp.ui.theme.PoppinsFont

@Composable
fun HomeScreen(
    name: String,
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
                    onClick = { onEventClick(heroEvent.id) },
                    events = heroEvent
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
                fontFamily = PoppinsFont,
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
                        onClick = { onEventClick(event.id) },
                        events = event
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
                fontFamily = PoppinsFont,
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
                        onClick = { onEventClick(event.id) },
                        events = event
                    )
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
        }

        // ── Full-width cards — one per event ───────────────────
        items(events.takeLast(2)) { event ->
            FullWidthEventCard(
                title = event.name,
                onClick = { onEventClick(event.id) },
                events = event
            )
            Spacer(modifier = Modifier.height(14.dp))
        }
    }
}