package com.example.internullstrorage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.internullstrorage.databinding.ActivityMainBinding
import java.io.FileOutputStream
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    val FILE_NAME = "tops-student.txt"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSave.setOnClickListener {
            val message = binding.etMessage.text.toString().trim()
            saveData(message)
        }
        binding.btnRead.setOnClickListener {
            readData()
        }
    }

    private fun readData() {
        try {

            val fin = openFileInput(FILE_NAME)
            Log.d("RESPONSE","size : ${fin.available()}")
            fin.available()
            var array : ByteArray = ByteArray(fin.available())
            fin.read(array)
            var message = String(array)

            binding.tvResult.text = message

            fin.close()
        }catch (e:Exception){
                e.printStackTrace()
        }
    }
    private fun saveData(message: String) {

        try {
            val fout: FileOutputStream = openFileOutput(FILE_NAME, MODE_PRIVATE)//MODE_APPEND tema last nu ave
                                                                                //MODE_PRIVATE tema je hase te avashe
            fout.write(message.toByteArray())
            fout.close()

            Toast.makeText(this, "Data saved successfully", Toast.LENGTH_SHORT).show()

        }catch (e:Exception){
            e.printStackTrace()
        }
    }
}