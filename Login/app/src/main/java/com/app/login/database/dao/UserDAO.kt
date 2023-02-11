package com.app.login.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.app.login.database.entity.User

@Dao
interface UserDAO {

    @Insert
    fun insertRecord(user: User)

    @Query("select * from user_table")
    fun getAllRecord() : List<User>

    @Query("select * from user_table where id = :uid")
    fun allUser(uid:Int) : User
}