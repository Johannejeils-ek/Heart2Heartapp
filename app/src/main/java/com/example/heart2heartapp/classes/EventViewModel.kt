package com.example.heart2heartapp.classes

import androidx.lifecycle.ViewModel
import com.example.heart2heartapp.R

class EventViewModel: ViewModel() {

    val exampleEvents: List<Event> = listOf(
        Event("Sauna gus med Andreas Bo", 1, R.drawable.eventest),
        Event("Stratego turnering på Bastard Café", 2, R.drawable.eventest),
        Event("Gratis BMO på Lagkagehuset", 3, R.drawable.eventest),
        Event("Lysshow på Bryggen", 4, R.drawable.eventest),
        Event("Foredrag om Leverpostejsbogen af Münster", 5, R.drawable.eventest),
        Event("Vinylmarked på Refshaleøen", 6, R.drawable.eventest),
        Event("Brætspilsaften på Café Mellemrummet", 7, R.drawable.eventest),
        Event("Silent disco i Kongens Have", 8, R.drawable.eventest),
        Event("Street food festival på Papirøen", 9, R.drawable.eventest),
        Event("Morgendans ved Ofelia Plads", 10, R.drawable.eventest),
        Event("Quiznight på en brun bodega", 11, R.drawable.eventest),
        Event("Krea-workshop: Lav din egen keramik", 12, R.drawable.eventest),
        Event("Filmvisning under åben himmel i Fælledparken", 13, R.drawable.eventest),
        Event("Ølsmagning på Nørrebro Bryghus", 14, R.drawable.eventest),
        Event("Yoga på taget af Illum", 15, R.drawable.eventest)

    )
    val events: List<Event> = exampleEvents

    fun getEvent(id: Int): Event? {

        return events.find { event -> event.id == id }
    }


}