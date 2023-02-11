package com.example.app

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.app.fragments.*
import com.example.weddingapp.R
import com.example.weddingapp.databinding.ActivityMainBinding
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.analytics.ktx.logEvent
import com.google.firebase.crashlytics.ktx.crashlytics
import com.google.firebase.crashlytics.ktx.setCustomKeys
import com.google.firebase.ktx.Firebase
import com.google.firebase.messaging.FirebaseMessaging
import okhttp3.Cache.Companion.key


open class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var firebaseAnalytics: FirebaseAnalytics


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        binding.tvHome.text = "Home"

        firebaseAnalytics = Firebase.analytics

        firebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_ITEM) {
            param(FirebaseAnalytics.Param.ITEM_ID, 1)
            param(FirebaseAnalytics.Param.ITEM_NAME, "umang")
            param(FirebaseAnalytics.Param.CONTENT_TYPE, "image")
        }
        val bundle = Bundle()
        bundle.putString("namer", "Umang")
        bundle.putString("age", "45")
        firebaseAnalytics.logEvent("MyDetail", bundle)


        binding.root.setOnClickListener { it ->
            throw RuntimeException("Test Crash") // Force a crash
        }

        val crashlytics = Firebase.crashlytics
        crashlytics.setCustomKeys {
            key("name", "umang")
            key("age", "20")
        }



        FirebaseMessaging.getInstance().token.addOnCompleteListener {
            if (it.isSuccessful) {
                var token = it.result
//               Toast.makeText(this, "$token", Toast.LENGTH_SHORT).show()
                Log.e("token", "token: " + token)

            }
        }

        val title = intent.getStringExtra("title")
        val message = intent.getStringExtra("message")
        Log.e("TAG", "main activity onCreate: " + title)
        if (title != null && message != null) {
            Toast.makeText(this, "title:$title ,  message:$message", Toast.LENGTH_SHORT).show()
        }


        supportFragmentManager.beginTransaction().apply {
            add(R.id.fragment_container, TaskFragment())
            addToBackStack(null)
            commit()

            binding.bottomNavigation.itemIconTintList = null

            binding.bottomNavigation.setOnItemSelectedListener {
                when (it.itemId) {
                    R.id.action_task -> {
                        addFragment(TaskFragment())
                        true
                    }
                    R.id.action_services -> {
                        addFragment(ServicesFragment())
                        true
                    }
                    R.id.action_budget -> {
                        addFragment(BudgetFragment())
                        true
                    }
                    R.id.action_chat -> {
                        addFragment(ChatFragment())
                        true
                    }
                    R.id.action_profile -> {
                        addFragment(ProfileFragment())
                        true
                    }
//                    R.id.action_settings -> {
//                        addFragment(SettingsFragment())
//                        true
//                    }
                    else -> false
                }
            }
        }

    }


    private fun addFragment(fragment: Fragment) {

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container, fragment)
            addToBackStack(null)
            commit()
        }

//        binding.tvHome.text = title
    }

}