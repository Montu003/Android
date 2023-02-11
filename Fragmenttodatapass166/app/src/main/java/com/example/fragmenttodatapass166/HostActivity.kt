package com.example.fragmenttodatapass166

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.fragmenttodatapass166.Fragment.FourthFragment

class HostActivity : AppCompatActivity()  , Communicator{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_host)
    }

    override fun setdata(name: String, age: Int) {
        var fragment = supportFragmentManager.findFragmentById(R.id.fragment_fourth)

        if(fragment is FourthFragment)
        {
            fragment.updateResult(name,age)
        }
        Toast.makeText(applicationContext,"name : $name\nAge : $age",Toast.LENGTH_SHORT).show()
    }
}