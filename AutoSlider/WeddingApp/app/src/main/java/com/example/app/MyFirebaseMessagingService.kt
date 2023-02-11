package com.example.app

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.weddingapp.R
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage


class MyFirebaseMessagingService : FirebaseMessagingService() {

    private val CHANNAL_ID = "myNotification"
    private val CHANNAL_NAME = "myNotification"
    private val CHANNAL_DESC = "notification description"


    @RequiresApi(Build.VERSION_CODES.M)
    override fun onMessageReceived(message: RemoteMessage) {
        super.onMessageReceived(message)
//        Log.e("message", "onMessageReceived: "+message )
//        Log.e("TAG", "onMessageReceived: "+message )
        val title = message.notification!!.title
        val messagebody = message.notification!!.body

        showNotification(title, messagebody)
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun showNotification(title: String?, message: String?) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            var channel = NotificationChannel(
                CHANNAL_ID,
                CHANNAL_NAME,
                NotificationManager.IMPORTANCE_HIGH
            ).apply {
                description = CHANNAL_DESC
                enableVibration(true)
                vibrationPattern = longArrayOf(100, 200, 300, 400, 500, 400, 300, 200, 400)
            }
            // Register the channel with the system
            val notificationManager: NotificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)

        }

        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("title", title)
        intent.putExtra("message", message)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
        val pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_IMMUTABLE)

        var builder = NotificationCompat.Builder(this, CHANNAL_ID)
            .setContentTitle(title)
            .setContentText(message)
            .setSmallIcon(R.drawable.notification)
            .setStyle(
                NotificationCompat.BigTextStyle()
                    .bigText(message)
            )
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setContentIntent(pendingIntent)
                .setVibrate(longArrayOf(100, 200, 300, 400, 500, 400, 300, 200, 400))

        var notificationCompat = NotificationManagerCompat.from(this)
            notificationCompat.notify(1, builder.build())

    }

    override fun onNewToken(token: String) {
        super.onNewToken(token)
        Log.d("TOKEN", "onNewToken: $token")
    }


//        val extras  = intent.extras
//        if (intent.extras  != null) {
//            val data1 = intent.extras?.getString("title")
//            val data2 = intent.extras?.getString("message")
//            Log.e("title" ,"data title: "+data1)
//            Log.e("message" ,"data message : "+data2)
  //             Toast.makeText(this, "title:$data1,message:$data2", Toast.LENGTH_SHORT).show()
//        }




}