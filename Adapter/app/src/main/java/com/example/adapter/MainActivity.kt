package com.example.adapter

import android.R
import android.icu.number.Notation.simple
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.adapter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    val languages = arrayOf("Java", "Kotlin", "Dart", "Python", "Ruby", "C#", "C language","Node js")
    lateinit var mAdapter: ArrayAdapter<String>
    lateinit var mSpinnerAdapter: ArrayAdapter<String>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // passing data to adapter using constructor
        mAdapter = ArrayAdapter(this, R.layout.simple_list_item_1, languages)
        mSpinnerAdapter = ArrayAdapter(this, R.layout.simple_spinner_dropdown_item, languages)
        // set adapter to adapter view


        binding.listItem.adapter = mAdapter
        binding.gridView.adapter = mAdapter
        binding.spinner.adapter = mSpinnerAdapter
        // listView Click Event

        binding.gridView.setOnItemClickListener{ AdapterView,view,po,l ->
            var lan = languages[po]
            Toast.makeText(this, "$lan", Toast.LENGTH_SHORT).show()

        }
        binding.listItem.setOnItemClickListener { adapterView, view, pos, l ->

            var lang = languages[pos]
            Toast.makeText(this, "$lang", Toast.LENGTH_SHORT).show()
        }
        // Spinner select event
        binding.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, pos: Int, p3: Long) {
                var lang = languages[pos]
                Toast.makeText(applicationContext, "$lang", Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
    }
}