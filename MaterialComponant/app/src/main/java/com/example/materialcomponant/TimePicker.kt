package com.example.materialcomponant

import android.icu.util.Calendar
import android.icu.util.TimeZone
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.format.DateFormat.is24HourFormat
import android.util.Log
import android.widget.Button
import android.widget.TimePicker
import com.example.materialcomponant.databinding.ActivityTimePickerBinding
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.TimeFormat
import java.text.SimpleDateFormat
import java.util.*

class TimePicker : AppCompatActivity() {

    lateinit var binding:ActivityTimePickerBinding

    var outputDateFormate=SimpleDateFormat("dd MMM yyyy",Locale.getDefault()).apply {
        timeZone= java.util.TimeZone.getTimeZone("UTC")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityTimePickerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initview()
    }

    private fun initview() {

       binding.btClock.setOnClickListener {
           openTimePicker()
       }

      binding.btDate.setOnClickListener {
          openDatePicker()
      }

    }

    private fun openTimePicker() {
        val isSystem24Hour = is24HourFormat(this)
        val clockFormat = if (isSystem24Hour) TimeFormat.CLOCK_24H else TimeFormat.CLOCK_12H

        val picker=MaterialTimePicker.Builder()
            .setTimeFormat(clockFormat)
            .setHour(12)
            .setMinute(10)
            .setTitleText("Select Time")
            .build()
            picker.show(supportFragmentManager,"Clock")

        picker.addOnNegativeButtonClickListener {
               Log.d("openTimePicker:", "Negative")
           }
           picker.addOnPositiveButtonClickListener {

               var h=picker.hour
               var min=picker.minute


               var show= if(h>0 && h<12){
                "Selected Time   $h : $min : Am"
               }
               else{
                 if(h==12){
                   "Selected Time   $h : $min PM"
                 }
                 else{
                   h=h-12
                   "Selected Time   $h : $min PM"
                 }
               }
               Log.d("openTimePicker:", "Positive")
               binding.tvClockData.text="$show"

           }
           picker.addOnCancelListener {
               Log.d("openTimePicker:", "Cancel")
           }
          picker.addOnDismissListener {
              Log.d("openTimePicker:", "Dismiss")
          }
    }

    private fun openDatePicker() {

        var datePicker = MaterialDatePicker.Builder.datePicker()
                .setTitleText("Select date")
                .setSelection(
                     MaterialDatePicker.thisMonthInUtcMilliseconds(),
                 )
                .build()
                datePicker.show(supportFragmentManager,"Date")


        datePicker.addOnPositiveButtonClickListener {
            Log.d("openDatePicker: ", "Positive")

            var dateSelected=outputDateFormate.format(it)
            binding.tvDate.text="Selected Date: ${dateSelected}"
        }

        datePicker.addOnNegativeButtonClickListener {
            Log.d("openDatePicker: ", "Negative")
        }

        datePicker.addOnCancelListener {
            Log.d("openDatePicker: ", "Cancel")
        }

        datePicker.addOnDismissListener {
            Log.d("openDatePicker: ", "Dismiss")
        }

    }
}


