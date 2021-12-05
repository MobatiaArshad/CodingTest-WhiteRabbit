package com.ems.codingtestarshad.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface userDao {

    @Query("SELECT * from userTable")
    fun getAll(): List<UsersData>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(homeData: UsersData)
}