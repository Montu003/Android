package com.example.recyclerview

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.clickevent.HomeActivity
import com.example.clickevent.R
import com.example.clickevent.VarticalActivity
import com.example.clickevent.databinding.ActivityRecyclerBinding
import com.example.clickevent.databinding.CustomProfileLayoutBinding
import com.example.clickevent.listener.OnListItemClickListener
import com.example.clickevent.model.movie
import com.example.clickevent.model.phone
import com.example.recyclerview.adapter.CustomHorizontalRecyclerAdapter
import com.example.recyclerview.adapter.CustomRecyclerAdapter

class RecyclerActivity : AppCompatActivity() {

    lateinit var binding: ActivityRecyclerBinding
    private var phoneList = mutableListOf<phone>()
    private lateinit var mAdapter: CustomRecyclerAdapter
    private lateinit var horizontalAdapter: CustomHorizontalRecyclerAdapter
    private var movieList = mutableListOf<movie>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecyclerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        prepareData()

        mAdapter = CustomRecyclerAdapter(this, phoneList)
        var manager = LinearLayoutManager(this)                            // vertically
        //var manager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        binding.rvList.layoutManager = manager
        binding.rvList.adapter = mAdapter

        horizontalAdapter = CustomHorizontalRecyclerAdapter(this, movieList)
        manager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.rvListHori.layoutManager = manager
        binding.rvListHori.adapter = horizontalAdapter

        horizontalAdapter.setOnListItemClickListener(object : OnListItemClickListener {
            override fun onCardClicked(pos: Int, movie: movie) {
                Toast.makeText(applicationContext, "${movie.title}", Toast.LENGTH_SHORT).show()
            }

            override fun onCardPhoneClicked(pos: Int, phone: phone) {

            }

            override fun onImageClicked(view: View, pos: Int, movie: movie) {
                Toast.makeText(applicationContext, "Image - $pos", Toast.LENGTH_SHORT).show()
                showCustomDialog(movie)
            }

            override fun onItemLayout(view: View, pos: Int) {
                var intent = Intent(this@RecyclerActivity, HomeActivity::class.java)
                intent.putExtra("title", movieList.get(pos).title)
                intent.putExtra("type", movieList.get(pos).type)
                intent.putExtra("rating", movieList.get(pos).rating)
                intent.putExtra("img", movieList.get(pos).image)
                startActivity(intent)
            }

            override fun onImagephoneClicked(view: View, pos: Int,phone: phone) {

            }
        })

        mAdapter.setOnListItemVarClickListener(object : OnListItemClickListener {
            override fun onCardClicked(pos: Int, movie: movie) {

            }
            override fun onCardPhoneClicked(pos: Int, phone: phone) {
                Toast.makeText(applicationContext, "${phone.title}", Toast.LENGTH_SHORT).show()
            }

            override fun onImageClicked(view: View, pos: Int, movie: movie) {

                Toast.makeText(applicationContext, "Image - $pos", Toast.LENGTH_SHORT).show()

            }

            override fun onItemLayout(view: View, pos: Int) {
                Toast.makeText(applicationContext, "Image - $pos", Toast.LENGTH_SHORT).show()

                var intent = Intent(this@RecyclerActivity, VarticalActivity::class.java)
                intent.putExtra("title", phoneList.get(pos).title)
                intent.putExtra("mrp", phoneList.get(pos).mrp)
                intent.putExtra("image", phoneList.get(pos).image)
                intent.putExtra("color", phoneList.get(pos).color)
                intent.putExtra("rating", phoneList.get(pos).rating)
                startActivity(intent)
            }

            override fun onImagephoneClicked(view: View, pos: Int,phone: phone) {
                showCustomDialog1(phone)
            }
        })
    }

    private fun showCustomDialog(movie: movie) {

        var bind = CustomProfileLayoutBinding.inflate(layoutInflater)

        var builder = AlertDialog.Builder(this)
            .setView(bind.root)

        bind.ivMontu.setImageResource(movie.image)
        var dialog = builder.create()
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
        dialog.show()
    }
    private fun showCustomDialog1(phone: phone) {

        var bind = CustomProfileLayoutBinding.inflate(layoutInflater)

        var builder = AlertDialog.Builder(this)
            .setView(bind.root)

        bind.ivMontu.setImageResource(phone.image)
        var dialog = builder.create()
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
        dialog.show()
    }

    private fun prepareData() {
        phoneList.add(phone(1, "iphone 8", 10000, R.drawable.images_2, "black", 3.0f))
        phoneList.add(phone(2, "iphone 9", 15000, R.drawable.image_0, "purple", 4.0f))
        phoneList.add(phone(3, "iphone 10", 20000, R.drawable.images_3, "white", 3.3f))
        phoneList.add(phone(4, "iphone 11", 25000, R.drawable.images_4, "pink", 4.0f))
        phoneList.add(phone(5, "iphone 12", 30000, R.drawable.images_5, "red", 3.0f))
        phoneList.add(phone(6, "iphone 13", 45000, R.drawable.images_7, "yellow", 5.0f))

        phoneList.add(phone(1, "iphone 8", 10000, R.drawable.images_2, "black", 3.0f))
        phoneList.add(phone(2, "iphone 9", 15000, R.drawable.image_0, "purple", 4.0f))
        phoneList.add(phone(3, "iphone 10", 20000, R.drawable.images_3, "white", 3.3f))
        phoneList.add(phone(4, "iphone 11", 25000, R.drawable.images_4, "pink", 4.0f))
        phoneList.add(phone(5, "iphone 12", 30000, R.drawable.images_5, "red", 3.0f))
        phoneList.add(phone(6, "iphone 13", 45000, R.drawable.images_7, "yellow", 5.0f))

        movieList.add(movie("Kgf 2", "kgf", 3.5f, R.drawable.image_12))
        movieList.add(movie("Bahubali", "bahubali", 2.8f, R.drawable.image_13))
        movieList.add(movie("Radhe shyam ", "radhe", 3.5f, R.drawable.image_51))
        movieList.add(movie("Jersey ", "jersey", 4.5f, R.drawable.image_52))
        movieList.add(movie("Pushpa ", "jhukega nahi sala", 5.0f, R.drawable.image_53))
        movieList.add(movie("Nadi Dosh ", "nadi", 5.0f, R.drawable.image_54))
    }
}