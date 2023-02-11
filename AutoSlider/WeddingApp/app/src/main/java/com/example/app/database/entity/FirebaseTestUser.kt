package com.example.app.database.entity

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

//@Parcelize
//data class FirebaseTestUser(
//    var uId:String? = null,
//    var email:String? = null,
//    var name:String? = null,
//    var messageList :ArrayList<Message?>? =null
//
//):Parcelable{
//
//   @Parcelize
//    data class Message(
//        var senderId : String?= null ,
//        var message:String? = null,
//        var time: Long? = null,
//    ):Parcelable
//
//}
@Parcelize
data class FirebaseTestUser(
    var uId:String? = null,
    var email:String? = null,
    var name:String? = null,


):Parcelable

    @Parcelize
    data class Message(
        var senderId : String?= null ,
        var message:String? = null,
        var time: Long? = null,
    ):Parcelable


