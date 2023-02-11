package com.example.datepicker

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.DatePicker
import android.widget.EditText
import android.widget.ImageView
import java.util.*

class DateActivity : AppCompatActivity() {

    val btnCalender:ImageView
    get() = findViewById(R.id.iv_date)

    val etDob: EditText
    get() = findViewById(R.id.et_dob)

    var dob:String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_date)

        btnCalender.setOnClickListener {
            pickdob()
        }
    }

    private fun pickdob(){

        var calendar = Calendar.getInstance()
        var mYear = calendar.get(Calendar.YEAR)
        var mMonth = calendar.get(Calendar.MONTH)
        var mDayofMonth = calendar.get(Calendar.DAY_OF_MONTH)

        var dialog=DatePickerDialog(this, object : DatePickerDialog.OnDateSetListener {
            override fun onDateSet(p0: DatePicker?, year: Int, month: Int, dayofMonth: Int) {

                var tempMonth = if ((month+1)<10) "0${month+1}" else month+1
                var tempDay = if (dayofMonth<10) "0${dayofMonth}" else dayofMonth

             /*   dob = "$dayofMonth/$month/$year"
                etDob.setText(dob)*/

                dob = "$tempDay/${tempMonth}/$year"
                etDob.setText(dob)
            }
        }, mYear, mMonth, mDayofMonth)
        dialog.show()
    }
}