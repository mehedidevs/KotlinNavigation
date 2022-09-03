package com.mehedi.kotlinnavigation

class BmiMessage {

    fun getMessage(bmi: Double): String {

        return when (bmi) {

            in 0.0..18.4 -> "UnderWeight"
            in 18.5..24.9 -> "Normal"
            in 25.0..29.9 -> "Pre Obesity"
            in 30.0..34.9 -> "Obesity Class 1"
            in 35.0..39.9 -> "Obesity Class 2"
            else -> "normal"


        }

    }


}