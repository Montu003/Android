package com.app.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.recyclerview.adapter.MovieAdapter
import com.app.recyclerview.adapter.PhoneAdapter
import com.app.recyclerview.databinding.ActivityCustomListBinding
import com.app.recyclerview.model.movie
import com.app.recyclerview.model.phone

class CustomListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCustomListBinding
    private var movieList = mutableListOf<movie>()
    private var phoneList = mutableListOf<phone>()
    lateinit var madapter : MovieAdapter
    lateinit var adapter : PhoneAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCustomListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        prepareData()

        adapter = PhoneAdapter(this,phoneList)
        val manager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        binding.listHori.layoutManager = manager
        binding.listHori.adapter = adapter

        // vertical
        madapter = MovieAdapter(this,movieList)
        val layout = LinearLayoutManager(this)
        binding.listView.layoutManager = layout
        binding.listView.adapter = madapter
    }

    private fun prepareData(){
        movieList.add(movie(1,"movie","movielist",2016,3f,R.drawable.ic_launcher_background))
        movieList.add(movie(2,"movie","movielist",2016,3f,R.drawable.ic_launcher_background))
        movieList.add(movie(3,"movie","movielist",2017,4f,R.drawable.ic_launcher_background))
        movieList.add(movie(4,"movie","movielist",2018,2.5f,R.drawable.ic_launcher_background))
        movieList.add(movie(5,"movie","movielist",2019,2f,R.drawable.ic_launcher_background))

        phoneList.add(phone(1,"iphone",452,"black",4f,R.drawable.ic_launcher_background))
        phoneList.add(phone(2,"iphone",452,"black",4f,R.drawable.ic_launcher_background))
        phoneList.add(phone(3,"vivo",523,"red",3f,R.drawable.ic_launcher_background))
        phoneList.add(phone(4,"oppo",125,"orange",2f,R.drawable.ic_launcher_background))
        phoneList.add(phone(5,"phone",120,"blue",5f,R.drawable.ic_launcher_background))

    }
}