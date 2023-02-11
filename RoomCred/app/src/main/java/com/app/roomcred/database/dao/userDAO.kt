package com.app.roomcred.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.app.roomcred.database.entity.User

@Dao
interface userDAO {

    @Insert
    fun insertRecord(user: User)

    @Update
    fun updateRecord(user: User)

    @Delete
    fun delateRecord(user: User)

    @Query("select * from 'user_table'")
    fun getAllRecords():List<User>

    @Query("select * from 'user_table' where id=:Uid")
    fun getUserRecords(Uid:Int):List<User>

}