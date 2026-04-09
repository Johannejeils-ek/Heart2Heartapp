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
import androidx.compose.material3.Button
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
import com.example.heart2heartapp.ui.theme.BricolageFont
import com.example.heart2heartapp.ui.theme.PoppinsFont
import com.example.heart2heartapp.R
import com.example.heart2heartapp.classes.Message

@Composable
fun ChatScreen () {
    Column (modifier = Modifier
        .background(Color(0xFFFFFFFF))){
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

    val messages = listOf(
        Message("Grethe", "You: Vi ses!", R.drawable.andrea),
        Message("Andrea", "Yes!", R.drawable.andrea),
        Message("Laura", "Så true!", R.drawable.andrea),
        Message("Natalie", "You: Det ved jeg ikke", R.drawable.andrea),
        Message("Solveigh", "Kommer du til saunagus?", R.drawable.andrea),
        Message("Johanne", "You: What's up guarl?", R.drawable.andrea),
        Message("Mathilde", "Ej det var vildt sjovt!", R.drawable.andrea),
        Message("Ida", "You: Elsker bare H2H", R.drawable.andrea),
        Message("Kathrine", "Ej så du Annika havde hjertet??", R.drawable.andrea),
        Message("Olivia", "You: Det skal vi gøre igen snart!", R.drawable.andrea),
        Message("Josephine", "You: Så du de havde keramik?", R.drawable.andrea),


        )

    LazyColumn {
        items(messages) { message ->
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
                    modifier = Modifier
                        .padding(vertical = 10.dp)
                        .padding(horizontal = 10.dp)
                )

                Divider()


            }
        }
    }