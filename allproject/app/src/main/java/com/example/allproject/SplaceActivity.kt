package com.example.allproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.allproject.sharePref.PrefManager
import com.example.onboardingscreen.activity.IntroActivity
import com.example.uidesign21_6.LoginActivity

class SplaceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splace)

        Handler().postDelayed(Runnable {

            var prefManager = PrefManager(this)

            if (!prefManager.getIntroStatus()){
                startActivity(Intent(this,IntroActivity::class.java))
            }else{
                if (!prefManager.getLoginStatus()) {
                    startActivity(Intent(this, LoginActivity::class.java))
                }else{
                    startActivity(Intent(this,HomeActivity::class.java))
                }
            }
        },3000)
        }
}