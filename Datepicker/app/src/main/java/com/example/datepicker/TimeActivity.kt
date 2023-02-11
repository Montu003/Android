 package com.example.datepicker

import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import java.time.Month
import java.util.*

class TimeActivity : AppCompatActivity() {

    val btnCalender:ImageView
        get() = findViewById(R.id.iv_Time)

    val ettime: EditText
        get() = findViewById(R.id.et_time)

    var dob:String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_time)

        btnCalender.setOnClickListener {
            pickdob()
        }
    }
    private fun pickdob(){

        var calendar = Calendar.getInstance()
        var mHour = calendar.get(Calendar.HOUR)
        var mMinute = calendar.get(Calendar.MINUTE)

        var dialog=TimePickerDialog(this,object :TimePickerDialog.OnTimeSetListener{
            override fun onTimeSet(p0: TimePicker?, mHour: Int, mMinute: Int) {

                var cleHour = if ((mHour)<10) "0${mHour}" else mHour
                var cleMinute = if (mMinute<10) "0${mMinute}" else mMinute

                ettime.setText("${cleHour} : ${cleMinute}")
            }
        },mHour,mMinute,false)
       dialog.show()
    }
}

