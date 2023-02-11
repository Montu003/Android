package com.app.roomdata.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.app.roomdata.database.dao.UserDAO
import com.app.roomdata.database.entity.User

@Database(entities = [User::class], version = 1)
abstract class AppDataBase : RoomDatabase() {

    abstract fun userDao() : UserDAO
}