package com.example.customview47

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.customview47.adapter.CustomListAdapter
import com.example.customview47.databinding.ActivityCustomListBinding
import com.example.customview47.model.person

class CustomListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCustomListBinding
    private var personList = mutableListOf<person>()
    private lateinit var mAdapter:CustomListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCustomListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        prepareData()
        //pass data to adapter using constructor
        mAdapter = CustomListAdapter(this,personList)
        binding.listItem.adapter = mAdapter

    }

    private fun prepareData() {

        personList.add(person(1,"Montu","Good Morning",R.drawable.image_1,"5.45pm"))
        personList.add(person(2,"Vraj","Good Night",R.drawable.image_2,"6.45am"))
        personList.add(person(3,"Romil","Good afternoon",R.drawable.image_3,"8.45am"))
        personList.add(person(4,"Vinay","Good evening",R.drawable.image_4,"2.45pm"))
        personList.add(person(5,"Keval","Good morning",R.drawable.image_5,"4.45am"))
        personList.add(person(6,"one and only keval","Good morning",R.drawable.keval,"9.45"))

        personList.add(person(1,"Montu","Good Morning",R.drawable.image_1,"5.45pm"))
        personList.add(person(2,"Vraj","Good Night",R.drawable.image_2,"6.45am"))
        personList.add(person(3,"Romil","Good afternoon",R.drawable.image_3,"8.45am"))
        personList.add(person(4,"Vinay","Good evening",R.drawable.image_4,"2.45pm"))
        personList.add(person(5,"Keval","Good morning",R.drawable.image_5,"4.45am"))
        personList.add(person(6,"one and only keval","Good morning",R.drawable.keval,"9.45"))

        personList.add(person(1,"Montu","Good Morning",R.drawable.image_1,"5.45pm"))
        personList.add(person(2,"Vraj","Good Night",R.drawable.image_2,"6.45am"))
        personList.add(person(3,"Romil","Good afternoon",R.drawable.image_3,"8.45am"))
        personList.add(person(4,"Vinay","Good evening",R.drawable.image_4,"2.45pm"))
        personList.add(person(5,"Keval","Good morning",R.drawable.image_5,"4.45am"))
        personList.add(person(6,"one and only keval","Good morning",R.drawable.keval,"9.45"))

        personList.add(person(1,"Montu","Good Morning",R.drawable.image_1,"5.45pm"))
        personList.add(person(2,"Vraj","Good Night",R.drawable.image_2,"6.45am"))
        personList.add(person(3,"Romil","Good afternoon",R.drawable.image_3,"8.45am"))
        personList.add(person(4,"Vinay","Good evening",R.drawable.image_4,"2.45pm"))
        personList.add(person(5,"Keval","Good morning",R.drawable.image_5,"4.45am"))
        personList.add(person(6,"one and only keval","Good morning",R.drawable.keval,"9.45"))

    }
}