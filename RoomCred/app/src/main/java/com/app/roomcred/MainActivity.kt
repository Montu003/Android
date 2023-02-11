package com.app.roomcred

import android.content.DialogInterface
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.app.roomcred.adapter.RecyclerAdapter
import com.app.roomcred.database.Appdatabase
import com.app.roomcred.database.entity.User
import com.app.roomcred.databinding.ActivityMainBinding
import com.app.roomcred.databinding.CustomDailogLayoutBinding
import com.app.roomcred.listner.OnItemClickListner

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var db: Appdatabase
    private lateinit var adapter: RecyclerAdapter
    var userList = mutableListOf<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = Room.databaseBuilder(this, Appdatabase::class.java, "tops-user.db")
            .allowMainThreadQueries().build()

        adapter = RecyclerAdapter(this, userList)

        val manger = LinearLayoutManager(applicationContext)
        binding.recyclerItem.layoutManager = manger

        binding.recyclerItem.adapter = adapter

        adapter.setOnClickListner(object : OnItemClickListner {

            override fun OnUpdateRecord(user: User) {
                showUpdateReocred(user)
            }

            override fun OnDeleteReocrd(user: User) {
                showDelateRecord(user)
            }
        })

        binding.rvSave.setOnClickListener {

            val name = binding.rvName.text.toString().trim()
            val email = binding.rvEmail.text.toString().trim()

            insertRecord(name, email)
        }
    }

    private fun showUpdateReocred(user: User) {

        val bind = CustomDailogLayoutBinding.inflate(layoutInflater)

        val builder = AlertDialog.Builder(this)
            .setView(bind.root)

        bind.tvName.setText(user.name)
        bind.tvEmail.setText(user.email)

        val alert = builder.create()
        alert.show()

        bind.tvUpdate.setOnClickListener {

            val name = bind.tvName.text.toString().trim()
            val email = bind.tvEmail.text.toString().trim()

            val muser = User(id = user.id, name = name, email = email)

            db.userdao.updateRecord(muser)
            updateList()

            alert.dismiss()

        }
    }

    private fun showDelateRecord(user: User) {

        AlertDialog.Builder(this)
            .setTitle("DeleteRecord")
            .setMessage("are you sure want to delate this item?")
            .setPositiveButton("Delete", DialogInterface.OnClickListener { dialogInterface, i ->
                db.userdao.delateRecord(user)
                updateList()

            }).setNegativeButton("Cancel", DialogInterface.OnClickListener { dialogInterface, i ->

            }).show()
    }

    private fun insertRecord(name: String, email: String) {

        val user = User(name = name, email = email)
        db.userdao.insertRecord(user)
        Toast.makeText(applicationContext, "Record add", Toast.LENGTH_SHORT).show()

        updateList()
    }

    private fun updateList() {

        val list = db.userdao.getAllRecords() as MutableList<User>
        adapter.setItems(list)
    }
}