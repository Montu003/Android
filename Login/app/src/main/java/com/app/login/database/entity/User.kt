package com.app.login.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class User(

    @PrimaryKey(autoGenerate = true)
    var id:Int = 0,
    var email:String,
    var password:Int
)
