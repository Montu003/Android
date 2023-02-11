package com.example.telegramapplication.Utils

import java.text.DecimalFormat
import java.text.NumberFormat

class utils {

    companion object{

        fun getFormettedNumber(number:Int) : String {

            val formatter: NumberFormat = DecimalFormat("00")
            val s: String = formatter.format(number)
            return s
        }
    }
}