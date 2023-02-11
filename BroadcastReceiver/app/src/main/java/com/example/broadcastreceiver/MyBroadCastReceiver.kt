package com.example.broadcastreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.provider.Settings
import android.util.Log

class MyBroadCastReceiver : BroadcastReceiver() {

  //  val connectivityManger = Context!!.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

    override fun onReceive(context: Context?, intent: Intent?) {

        intent?.let {

            if (it.action == Intent.ACTION_AIRPLANE_MODE_CHANGED) {

                if (isAirplaneModeOn(context!!)){
                    Log.d("MyApp", "onReceive: Airplane Mode ON ")
                }else {
                    Log.d("MyApp", "onReceive: Airplane Mode OFF ")
                }

//                Toast.makeText(context, "Airplane Mode Changed", Toast.LENGTH_SHORT).show()
                Log.d("MyApp", "onReceive: Airplane Mode Changed ")

            } else if (it.action == Intent.ACTION_DATE_CHANGED) {

//                Toast.makeText(context, "System Date Changed", Toast.LENGTH_SHORT).show()
                Log.d("MyApp", "onReceive: System Date Changed ")

            } else  if (it.action == "android.net.conn.CONNECTIVITY_CHANGE"){

                if (isNetworkModeOn(context!!)){
                    Log.d("MyApp", "onReceive: Network Mode ON ")
                }else {
                    Log.d("MyApp", "onReceive:Network Mode OFF ")
                }

                Log.d("MyApp", "onReceive: Connectivity Change")
            }
            else{
            }
        }
    }

    private fun isAirplaneModeOn(context: Context): Boolean {

        return Settings.System.getInt(
            context.contentResolver,
            Settings.Global.AIRPLANE_MODE_ON,
            0
        ) !== 0
    }

    private fun isNetworkModeOn(context: Context): Boolean {

        return Settings.System.getInt(
            context.contentResolver,
            Settings.Global.NETWORK_PREFERENCE,
            0
        ) !== 0
    }
}