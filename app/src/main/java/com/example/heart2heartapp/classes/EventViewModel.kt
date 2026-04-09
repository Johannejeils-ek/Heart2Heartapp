package com.example.heart2heartapp.classes

import androidx.lifecycle.ViewModel
import com.example.heart2heartapp.R

class EventViewModel: ViewModel() {

    val exampleEvents: List<Event> = listOf(
        Event("Sauna gus med Andreas Bo", 1),
        Event("Stratego turnering på Bastard Café", 2),
        Event("Gratis BMO på Lagkagehuset", 3),
        Event("Lysshow på Bryggen", 4),
        Event("Foredrag om Leverpostejsbogen af Münster", 5),
        Event("Vinylmarked på Refshaleøen", 6),
        Event("Brætspilsaften på Café Mellemrummet", 7),
        Event("Silent disco i Kongens Have", 8),
        Event("Street food festival på Papirøen", 9),
        Event("Morgendans ved Ofelia Plads", 10),
        Event("Quiznight på en brun bodega", 11),
        Event("Krea-workshop: Lav din egen keramik", 12),
        Event("Filmvisning under åben himmel i Fælledparken", 13),
        Event("Ølsmagning på Nørrebro Bryghus", 14),
        Event("Yoga på taget af Illum", 15)

    )
    val events: List<Event> = exampleEvents

    fun getEvent(id: Int): Event? {

        return events.find { event -> event.id == id }
    }


}