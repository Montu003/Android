package com.example.adapater

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.TextView
import android.widget.Toast
import com.example.adapater.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var language = arrayOf("Java","Kotlin","C++","Python","Dart","Java script")
    private var states = arrayOf("Maharast","Mp","Nepal","Python","Dart","Java script")
    private var company = arrayOf("Retry infotech","Switchcaseinfotech","diversity Infotech","Coodonnier","Dart","Java script")
    private var countries = arrayOf("Bharat","Nepal","Bhutan","Bhavangar","Surat","Tirupati")
    private lateinit var mAdapter: ArrayAdapter<String>
    private lateinit var mSpinnerAdapter: ArrayAdapter<String>
    private lateinit var mGridAdapter: ArrayAdapter<String>
    private lateinit var mAutoAdapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // List
        mAdapter = ArrayAdapter(this,android.R.layout.simple_expandable_list_item_1,language)
        binding.listView.adapter = mAdapter

        binding.listView.setOnItemClickListener { adapterView, view, pos, l ->

            var lang = language[pos]
            Toast.makeText(applicationContext, "$lang", Toast.LENGTH_SHORT).show()
        }

        mSpinnerAdapter = ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,countries)
        binding.Spinner.adapter = mSpinnerAdapter

        binding.Spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, pos: Int, p3: Long) {
                var country = countries[pos]
                Toast.makeText(applicationContext, "$country", Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        mGridAdapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,states)
        binding.gridView.adapter = mGridAdapter

        binding.gridView.setOnItemClickListener { adapterView, view, pos, l ->

            var states = states[pos]
            Toast.makeText(applicationContext, "$states", Toast.LENGTH_SHORT).show()
        }

        mAutoAdapter = ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,company)
        binding.auto.setAdapter(mAutoAdapter)

        binding.auto.setOnItemClickListener { adapterView, view, pos, l ->

            var tview = view as TextView
            var lang = tview.text

            Toast.makeText(applicationContext, "$lang", Toast.LENGTH_SHORT).show()
        }
    }
}