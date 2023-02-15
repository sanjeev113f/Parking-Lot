package com.example.models
import com.example.services.Fair
import com.example.services.Parking
import java.util.*

class Receipt {
    private val parking: Parking = Parking()
    private var receiptNumber = 1
    private var entryDateTime: Date? = null
    private var exitDateTime: Date? = null
    private var fees = 0
    private var fair: Fair = Fair()

    fun generateReceipt(type: VehicleType, place: Location, inTime: Date?): Receipt {
        val newReceipt = Receipt()
        newReceipt.receiptNumber = receiptNumber++
        newReceipt.entryDateTime = inTime         //not companion object so need to initialise first
        newReceipt.exitDateTime = Date()
        parking.unAssignSpot(1)
        newReceipt.fees = fair.getFare(type, place, 3)
        return newReceipt
    }
}
