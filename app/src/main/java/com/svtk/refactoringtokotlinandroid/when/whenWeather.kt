package com.svtk.refactoringtokotlinandroid

import android.R.color.*

fun updateWeather(celsiusDegrees: Double) {
    val description: String
    val colour: Int
    when (celsiusDegrees) {
        in -50..0 -> {
            description = "cold"
            colour = holo_blue_light
        }
        in 0..15 -> {
            description = "mild"
            colour = holo_orange_light
        }
        else -> {
            description = "hot"
            colour = holo_red_light
        }
    }
}

fun updateWeather1(celsiusDegrees: Double) {
    val (description: String, colour: Int) = when (celsiusDegrees) {
        in -50..0 -> "cold" to holo_blue_light
        in 0..15 -> "mild" to holo_orange_light
        else -> "hot" to holo_red_light
    }
}