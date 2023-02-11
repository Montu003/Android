package com.app.roomdata.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.app.roomdata.database.entity.User

@Dao
interface UserDAO {

    @Insert
    fun insertRecord(user:User)

    @Update
    fun updateRecord(user: User)

    @Delete
    fun deleteRecord(user: User)

    @Query("select * from user_table")
    fun getAllRecord() : List<User>

    @Query("select * from user_table where id = :uid")
    fun allUser(uid:Int) : User
}