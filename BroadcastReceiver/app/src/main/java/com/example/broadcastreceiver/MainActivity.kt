package com.example.broadcastreceiver

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    var MyBroadCastReceiver = MyBroadCastReceiver()

//    val view: ConstraintLayout
//        get() = findViewById(com.google.android.material.R.id.accelerate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var intentFilter = IntentFilter()
        intentFilter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED)
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE")
        registerReceiver(MyBroadCastReceiver,intentFilter)

    }

    override fun onDestroy() {
        super.onDestroy()

        if (MyBroadCastReceiver!=null)
        {
            unregisterReceiver(MyBroadCastReceiver)
        }
    }

    override fun onStop() {
        super.onStop()

        if (MyBroadCastReceiver!=null)
        {
            unregisterReceiver(MyBroadCastReceiver)
        }
    }

//    fun onNetworkChange(isConnected: Boolean) {
//
//        var message = if (isConnected) {
//            "internet connected"
//        } else {
//            "no internet connection"
//        }
//
//        Snackbar.make(view, message, Snackbar.LENGTH_SHORT)
//            .show()
//
//    }
}