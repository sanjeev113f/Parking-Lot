package com.example.models

import com.example.services.Parking
import java.util.*

class Ticket {
    private var ticketNumber = 1
    private var spotNumber = 1
    private var entryDateTime: Date? = null
    private val parking: Parking = Parking()
    fun generateTicket(): Ticket {
        val newTicket = Ticket()
        newTicket.ticketNumber++
        newTicket.spotNumber = parking.findSpot()
        parking.assignSpot(spotNumber)
        newTicket.entryDateTime = Date()
        return newTicket
    }

    fun getEntryTime(): Date? {
        return entryDateTime
    }
}