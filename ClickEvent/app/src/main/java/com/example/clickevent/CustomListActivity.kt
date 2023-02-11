package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.clickevent.R
import com.example.clickevent.databinding.ActivityCustomListBinding
import com.example.clickevent.model.phone
import com.example.recyclerview.adapter.CustomListAdapter

class CustomListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCustomListBinding
    private var phoneList = mutableListOf<phone>()
    private lateinit var mAdapter: CustomListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCustomListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        prepareData()
        //pass data to adapter using constructor
        mAdapter = CustomListAdapter(this,phoneList)
        binding.listItem.adapter = mAdapter

    }

    private fun prepareData() {
        phoneList.add(phone(1,"iphone 8",10000,R.drawable.images_2,"black",3.0f))
        phoneList.add(phone(2,"iphone 9",15000, R.drawable.image_0,"purple",4.0f))
        phoneList.add(phone(3,"iphone 10",20000,R.drawable.images_3,"white",3.3f))
        phoneList.add(phone(4,"iphone 11",25000,R.drawable.images_4,"pink",4.0f))
        phoneList.add(phone(5,"iphone 12",30000,R.drawable.images_5,"red",3.0f))
        phoneList.add(phone(6,"iphone 13",45000,R.drawable.images_7,"yellow",5.0f))

        phoneList.add(phone(1,"iphone 8",10000,R.drawable.images_2,"black",3.0f))
        phoneList.add(phone(2,"iphone 9",15000, R.drawable.image_0,"purple",4.0f))
        phoneList.add(phone(3,"iphone 10",20000,R.drawable.images_3,"white",3.3f))
        phoneList.add(phone(4,"iphone 11",25000,R.drawable.images_4,"pink",4.0f))
        phoneList.add(phone(5,"iphone 12",30000,R.drawable.images_5,"red",3.0f))
        phoneList.add(phone(6,"iphone 13",45000,R.drawable.images_7,"yellow",5.0f))

        phoneList.add(phone(1,"iphone 8",10000,R.drawable.images_2,"black",3.0f))
        phoneList.add(phone(2,"iphone 9",15000, R.drawable.image_0,"purple",4.0f))
        phoneList.add(phone(3,"iphone 10",20000,R.drawable.images_3,"white",3.3f))
        phoneList.add(phone(4,"iphone 11",25000,R.drawable.images_4,"pink",4.0f))
        phoneList.add(phone(5,"iphone 12",30000,R.drawable.images_5,"red",3.0f))
        phoneList.add(phone(6,"iphone 13",45000,R.drawable.images_7,"yellow",5.0f))

        phoneList.add(phone(1,"iphone 8",10000,R.drawable.images_2,"black",3.0f))
        phoneList.add(phone(2,"iphone 9",15000, R.drawable.image_0,"purple",4.0f))
        phoneList.add(phone(3,"iphone 10",20000,R.drawable.images_3,"white",3.3f))
        phoneList.add(phone(4,"iphone 11",25000,R.drawable.images_4,"pink",4.0f))
        phoneList.add(phone(5,"iphone 12",30000,R.drawable.images_5,"red",3.0f))
        phoneList.add(phone(6,"iphone 13",45000,R.drawable.images_7,"yellow",5.0f))
    }
}