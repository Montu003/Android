package com.example.materialcomponant

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.materialcomponant.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var adapter:ArrayAdapter<String>
    val cities = arrayOf("surat","Bhavngar","Ramadhari","Navasari","Bilimora","Rajkot","Dubai","Varacha","Dhanlaxmi")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,cities)
        binding.etCity.setAdapter(adapter)
    }
}