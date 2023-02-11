package com.example.animation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView

class TweeningActivity : AppCompatActivity() {

    val ivimage:ImageView
    get() = findViewById(R.id.iv_image)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tweening)


       var animation =  AnimationUtils.loadAnimation(this,R.anim.rotate_animation)

            ivimage.setOnClickListener {
                ivimage.startAnimation(animation)
            }
    }
}