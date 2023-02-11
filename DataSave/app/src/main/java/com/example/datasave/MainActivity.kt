package com.example.datasave

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.datasave.databinding.ActivityMainBinding
import com.example.xampplocal.sharepref.PrefManager

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Handler().postDelayed({
            var prefManager = PrefManager(this)
            if(!prefManager.getLoginStatus()){
                startActivity(Intent(this,LoginActivity::class.java))
                finish()

            }else{
                if(prefManager.getLoginStatus()){
                    startActivity(Intent(this,HomeActivity::class.java))
                    finish()

                }/*else{
                    startActivity(Intent(this,MainActivity::class.java))
                }*/
            }
        },3000)


    }
}