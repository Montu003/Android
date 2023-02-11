package com.example.app.activitys

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat
import com.example.app.MainActivity
import com.example.app.fragments.TaskFragment
import com.example.weddingapp.R
import com.example.weddingapp.databinding.ActivityTaskBinding
import com.google.firebase.messaging.FirebaseMessaging

class TaskActivity : AppCompatActivity() {

    private lateinit var binding:ActivityTaskBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTaskBinding.inflate(layoutInflater)
        setContentView(binding.root)


        var fragment = TaskFragment()
        var manager = supportFragmentManager
        var transaction = manager.beginTransaction()
        transaction.add(R.id.fragment_container, fragment)
        transaction.commit()


    }

}
