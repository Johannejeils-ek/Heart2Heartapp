package com.example.heart2heartapp.classes

import androidx.lifecycle.ViewModel

class EventViewModel: ViewModel() {

    val exampleEvents: List<Event> = listOf(
        Event("Sauna gus med Andreas Bo", 1),
        Event("Stratego turnering på Bastard Café", 2),
        Event("Gratis BMO på Lagkagehuset", 3),
        Event("Lysshow på Bryggen", 4),
        Event("Foredrag om Leverpostejsbogen af Münster", 5)
    )
    val events: List<Event> = exampleEvents

    fun getEvent(id: Int): Event? {

        return events.find { event -> event.id == id }
    }
}