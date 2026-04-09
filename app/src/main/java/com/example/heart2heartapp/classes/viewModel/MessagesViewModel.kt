package com.example.heart2heartapp.classes.viewModel

import androidx.lifecycle.ViewModel
import com.example.heart2heartapp.R
import com.example.heart2heartapp.classes.Message

class MessagesViewModel: ViewModel() {

    val messages = listOf(
        Message(1, "Grethe", "You: Vi ses!", R.drawable.andrea),
        Message(2, "Andrea", "Yes!", R.drawable.andrea),
        Message(3, "Laura", "Så true!", R.drawable.andrea),
        Message(4, "Natalie", "You: Det ved jeg ikke", R.drawable.andrea),
        Message(5, "Solveigh", "Kommer du til saunagus?", R.drawable.andrea),
        Message(6, "Johanne", "You: What's up guarl?", R.drawable.andrea),
        Message(7, "Mathilde", "Ej det var vildt sjovt!", R.drawable.andrea),
        Message(8, "Ida", "You: Elsker bare H2H", R.drawable.andrea),
        Message(9, "Kathrine", "Ej så du Annika havde hjertet??", R.drawable.andrea),
        Message(10, "Olivia", "You: Det skal vi gøre igen snart!", R.drawable.andrea),
        Message(11, "Josephine", "You: Så du de havde keramik?", R.drawable.andrea),


        )

}