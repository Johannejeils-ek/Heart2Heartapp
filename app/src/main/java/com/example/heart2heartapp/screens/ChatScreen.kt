package com.example.heart2heartapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.heart2heartapp.ui.theme.BricolageFont
import com.example.heart2heartapp.ui.theme.PoppinsFont
import com.example.heart2heartapp.classes.Message
import com.example.heart2heartapp.classes.viewModel.MessagesViewModel

@Composable
fun ChatScreen () {
    Column (modifier = Modifier
        .background(Color(0xFFFFFFFF))){
        Header(BricolageFont)
        ListOfMessages(PoppinsFont)
    }
}

@Composable
fun Header (fontFamily: FontFamily){
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
fun ListOfMessages(fontFamily: FontFamily) {
    val messagesViewModel = viewModel<MessagesViewModel>()

    LazyColumn {
        items(messagesViewModel.messages) { message ->
            IndividualChatBox(message)
        }
    }
}

    @Composable
    fun IndividualChatBox(message: Message) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Image(
                painter = painterResource(message.image),
                contentDescription = "ProfilePic",
                modifier = Modifier
                    .size(100.dp)
            )
            Column(
                modifier = Modifier
                    .padding(start = 30.dp)
            ) {
                Text(
                    text = message.name,
                    fontSize = 30.sp,
                    fontFamily = PoppinsFont,
                    textAlign = TextAlign.Start,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 10.dp)
                        .padding(horizontal = 8.dp)
                )
                Text(
                    text = message.lastMessage,
                    fontFamily = PoppinsFont,
                    modifier = Modifier
                        .padding(vertical = 10.dp)
                        .padding(horizontal = 10.dp)
                )
                Divider()
            }
        }
    }