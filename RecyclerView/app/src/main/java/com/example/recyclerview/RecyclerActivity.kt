package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerview.adapter.CustomHorizontalRecyclerAdapter
import com.example.recyclerview.adapter.CustomListAdapter
import com.example.recyclerview.adapter.CustomRecyclerAdapter
import com.example.recyclerview.databinding.ActivityRecyclerBinding
import com.example.recyclerview.model.movie
import com.example.recyclerview.model.phone

class RecyclerActivity : AppCompatActivity() {

    lateinit var binding:ActivityRecyclerBinding
    private var phoneList = mutableListOf<phone>()
    private var movieList = mutableListOf<movie>()
    private lateinit var mAdapter:CustomRecyclerAdapter
    private lateinit var horizontalAdapter: CustomHorizontalRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecyclerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        prepareData()

        mAdapter = CustomRecyclerAdapter(this,phoneList)
       var manager = LinearLayoutManager(this)                            // vertically
        //var manager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        binding.rvList.layoutManager = manager
        binding.rvList.adapter = mAdapter

        horizontalAdapter = CustomHorizontalRecyclerAdapter(this,movieList)
        manager =   LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        binding.rvListHori.layoutManager = manager
        binding.rvListHori.adapter = horizontalAdapter

    }

    private fun prepareData() {
        phoneList.add(phone(1,"iphone 8",10000,R.drawable.images_1,"black",3.0f))
        phoneList.add(phone(2,"iphone 9",15000, R.drawable.images_2,"black",4.0f))
        phoneList.add(phone(3,"iphone 10",20000,R.drawable.images_3,"black",3.3f))
        phoneList.add(phone(4,"iphone 11",25000,R.drawable.images_4,"black",4.0f))
        phoneList.add(phone(5,"iphone 12",30000,R.drawable.images_5,"black",3.0f))
        phoneList.add(phone(6,"iphone 13",45000,R.drawable.images_6,"black",5.0f))

        phoneList.add(phone(1,"iphone 8",10000,R.drawable.images_1,"white",3.0f))
        phoneList.add(phone(2,"iphone 9",15000, R.drawable.images_2,"white",4.0f))
        phoneList.add(phone(3,"iphone 10",20000,R.drawable.images_3,"white",3.3f))
        phoneList.add(phone(4,"iphone 11",25000,R.drawable.images_4,"white",4.0f))
        phoneList.add(phone(5,"iphone 12",30000,R.drawable.images_5,"white",3.0f))
        phoneList.add(phone(6,"iphone 13",45000,R.drawable.images_6,"white",5.0f))

       movieList.add(movie("movie","car",2.0f,R.drawable.image_movies))
       movieList.add(movie("Dangal","Dangal",2.0f,R.drawable.image_11))
       movieList.add(movie("Kgf 2","car",2.0f,R.drawable.image_12))
       movieList.add(movie("bahubali","car",2.0f,R.drawable.image_13))
       movieList.add(movie("Satyamev jayate","car",2.0f,R.drawable.image_14))
       movieList.add(movie("sonu tane bharosho nay","car",2.0f,R.drawable.image_15))
       movieList.add(movie("dhum","car",2.0f,R.drawable.image_16))
       movieList.add(movie("tazan","car",2.0f,R.drawable.image_17))
    }
}