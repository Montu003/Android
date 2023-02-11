package com.app.roomdata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.app.roomdata.adapter.RecyclerAdapter
import com.app.roomdata.database.AppDataBase
import com.app.roomdata.database.entity.User
import com.app.roomdata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var db:AppDataBase
    private lateinit var adapter: RecyclerAdapter
    var  userList = mutableListOf<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = Room.databaseBuilder(this,AppDataBase::class.java,"khodal.db").allowMainThreadQueries().build()


        adapter = RecyclerAdapter(this, userList)

        var manager = LinearLayoutManager(applicationContext)
        binding.rvRecycler.layoutManager = manager

        binding.rvRecycler.adapter = adapter

        binding.btnSave.setOnClickListener {

            var name = binding.etName.text.toString().trim()
            var email = binding.etEmail.text.toString().trim()

            insertRecord(name,email)
        }
    }

    private fun insertRecord(name: String, email: String) {
         var user = User(name = name, email = email)

        db.userdao.insertRecord(user)

        updateList()
    }

    private fun updateList() {

        var list = db.userdao.getAllRecord() as MutableList<User>
        adapter.setData(list)
    }
}