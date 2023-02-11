package com.example.fragmenttodatapass166

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fragmenttodatapass166.Fragment.FirstFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var fragment = FirstFragment()
        var manager = supportFragmentManager
        var transaction = manager.beginTransaction()
        transaction.add(R.id.fragment_container,fragment)
        transaction.commit()
    }
}