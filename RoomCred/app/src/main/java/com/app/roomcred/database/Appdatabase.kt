package com.app.roomcred.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.app.roomcred.database.dao.userDAO
import com.app.roomcred.database.entity.User

@Database(entities = [User::class], version = 1)
abstract class Appdatabase :RoomDatabase(){

    abstract val userdao: userDAO
}