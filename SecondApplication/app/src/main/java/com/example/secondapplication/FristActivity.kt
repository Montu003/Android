package com.example.secondapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class FristActivity : AppCompatActivity() {

    lateinit var btnsubmit:Button
    lateinit var etName:EditText
    lateinit var etEmail:EditText
    lateinit var etAge:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_frist)

        btnsubmit = findViewById(R.id.btn_submit)
        etName = findViewById(R.id.et_Name)
        etEmail = findViewById(R.id.et_Email)
        etAge = findViewById(R.id.et_Age)

        btnsubmit.setOnClickListener{

            var Name = etName.text.toString().trim()
            var Email = etEmail.text.toString().trim()
            var Age = etAge.text.toString().trim()

            var intent = Intent(this,SecondActivity::class.java)
            intent.putExtra("Name",Name)
            intent.putExtra("Email",Email)
            intent.putExtra("Age",Age)
            startActivity(intent)
        }
    }
}