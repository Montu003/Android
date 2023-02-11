package com.app.login.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.app.login.database.dao.UserDAO
import com.app.login.database.entity.User

@Database(entities = [User::class], version = 1)
abstract class AppDataBase : RoomDatabase() {

    abstract val userdao : UserDAO
}