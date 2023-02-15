package com.example.services
import com.example.models.VehicleType

class Parking {
    private val vehiclesLimitCount: MutableMap<VehicleType, Int> = HashMap()
    private val slotsLimit = 100
    private val slots = IntArray(slotsLimit)
    private val vehiclesCountInParking: MutableMap<VehicleType, Int> = HashMap()

    init {
        vehiclesLimitCount[VehicleType.Motorcycle] = 10
        vehiclesLimitCount[VehicleType.Car] = 50
        vehiclesLimitCount[VehicleType.Bus] = 40
        vehiclesCountInParking[VehicleType.Motorcycle] = 0
        vehiclesCountInParking[VehicleType.Car] = 0
        vehiclesCountInParking[VehicleType.Bus] = 0
        for (i in 0 until slotsLimit) {
            slots[i] = 0
        }
    }

    fun findSpot(): Int {
        var i = 0
        while (i < slotsLimit) {
            if (slots[i] == 0) return i + 1
            i++
        }
        return i
    }

    fun canFindSpot(type: VehicleType): Boolean {
        if (vehiclesCountInParking[type] == vehiclesLimitCount[type]) {
            return false
        }
        var i= 1
        while (i < slotsLimit) {
            if (slots[i] == 0) return true
            i++
        }
        return false
    }

    fun assignSpot(spotNumber: Int) {
        slots[spotNumber -1] = 1
    }

    fun unAssignSpot(spotNumber: Int) {
        slots[spotNumber - 1] = 1
    }
}