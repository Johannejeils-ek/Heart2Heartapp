package com.example.heart2heartapp.classes

import androidx.lifecycle.ViewModel
import com.example.heart2heartapp.R

class EventViewModel: ViewModel() {

    val exampleEvents: List<Event> = listOf(
        Event("Sauna gus med Andreas Bo", 1, R.drawable.saunagus),
        Event("Brætspilsaften på Bastard Café", 2, R.drawable.boardgame),
        Event("Gratis BMO på Lagkagehuset", 3, R.drawable.bmo),
        Event("Lysshow på Bryggen", 4, R.drawable.lightshow),
        Event("Foredrag om Heated Rivalry af Rachel Reid", 5, R.drawable.heated),
        Event("Vinylmarked på Refshaleøen", 6, R.drawable.vinyl),
        Event("Løbeklub på frederiksberg", 7, R.drawable.runclub),
        Event("Silent disco i Refshaleøen", 8, R.drawable.disco),
        Event("Street food festival på Papirøen", 9, R.drawable.streetfood),
        Event("Morgendans ved Ofelia Plads", 10, R.drawable.morningdans),
        Event("Quiznight på en brun bodega", 11, R.drawable.quiznight),
        Event("Krea-workshop: Lav din egen keramik", 12, R.drawable.kreaworkshop),
        Event("Keramik workshop på Creative space ", 13, R.drawable.creativespace),
        Event("Ølsmagning på Nørrebro Bryghus", 14, R.drawable.beer),
        Event("Yoga på taget af Illum", 15, R.drawable.yoga)

    )
    val events: List<Event> = exampleEvents

    fun getEvent(id: Int): Event? {

        return events.find { event -> event.id == id }
    }


}