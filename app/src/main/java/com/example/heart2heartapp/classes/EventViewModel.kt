package com.example.heart2heartapp.classes

import androidx.lifecycle.ViewModel

class EventViewModel: ViewModel() {

    val events: List<Event> = listOf(Event("Sauna gus med Andreas Bo", 1), Event("Stratego turnering på Bastard Café", 2))

    fun getEvent(id: Int): Event? {

        return events.find { event -> event.id == id }
    }
}