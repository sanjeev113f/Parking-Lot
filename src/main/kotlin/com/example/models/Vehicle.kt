package com.example.models
import com.example.services.Parking
import java.util.*

class Vehicle(type: VehicleType, location: Location) {
    private var ticket = Ticket()
    private val receipt = Receipt()
    private val parking = Parking()
    private val typeOfVehicle = type
    private val place = location

    fun park(): String {
        if (parking.canFindSpot(typeOfVehicle)) {
            ticket = ticket.generateTicket()
            println(ticket.getEntryTime())
            return ticket.toString()
        }
        else {
            return "No space available for $typeOfVehicle"
        }
    }
    fun unPark(): String {
        return receipt.generateReceipt(typeOfVehicle, place,ticket.getEntryTime()).toString()
    }

    fun getEntryTime(): Date? {
        return ticket.getEntryTime()
    }
}