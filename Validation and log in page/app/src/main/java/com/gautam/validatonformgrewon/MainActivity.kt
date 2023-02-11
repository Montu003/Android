package com.gautam.validatonformgrewon

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.gautam.validatonformgrewon.databinding.ActivityMainBinding
import com.gautam.validatonformgrewon.fragments.HomeFragment
import com.gautam.validatonformgrewon.fragments.ProfileFragments
import com.gautam.validatonformgrewon.fragments.SettingsFragment
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.messaging.FirebaseMessaging

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        FirebaseAnalytics.getInstance(this)

        val message = intent.getStringExtra("title")
        val description = intent.getStringExtra("messagebody")
        if (message != null && description != null) {
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("title", message)
            intent.putExtra("messagebody", description)
            startActivity(intent)
        }
        replaceFragment(HomeFragment(), "Home")
        FirebaseMessaging.getInstance().token.addOnCompleteListener {
            if (it.isSuccessful) {
                var token = it.result
                Log.e("token", "token: " + token)
            }
        }
        binding.bnBottomnavi.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.ic_home -> {
                    replaceFragment(HomeFragment(), "Home")
                    true
                }
                R.id.ic_profile -> {
                    replaceFragment(ProfileFragments(), "profils")
                    true
                }
                R.id.ic_seeting -> {
                    replaceFragment(SettingsFragment(), "settings")
                    true
                }

                else -> {
                    false
                }
            }
        }
    }

    //  intent.putExtra("title")
    //  intent.putExtra("messagebody")
    // startActivity(intent)

    private fun replaceFragment(fragment: Fragment, tag: String) {
        var manager = supportFragmentManager
        val transaction = manager.beginTransaction()
        transaction.replace(R.id.fl_wallpeper, fragment, tag)
        transaction.commit()
    }
}
