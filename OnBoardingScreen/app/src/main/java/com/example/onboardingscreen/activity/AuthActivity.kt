package com.example.onboardingscreen.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fragment14_6.fragments.LoginFragment
import com.example.onboardingscreen.R

class AuthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        var fragment = LoginFragment()
        var manager = supportFragmentManager
        var transaction = manager.beginTransaction()
        transaction.add(R.id.fragment_container,fragment)
        transaction.commit()
    }
}