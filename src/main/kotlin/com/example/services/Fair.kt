package com.example.services

import com.example.models.VehicleType
import com.example.models.Location

class Fair {
    fun getFare(type: VehicleType, modelType: Location, hours: Int): Int {
        val fare = 0
        return when (modelType) {
            Location.Mall -> {
                if (type === VehicleType.Motorcycle) {
                    return hours * 10
                } else if (type === VehicleType.Car) {
                    return hours * 20
                }
                hours * 50
            }

            else -> {
                fare
            }
        }
    }
}
