package com.ssh.roomdb

import androidx.room.*

@Dao
interface UserDao {

    @Query("SELECT * FROM user")
    fun getAlluser(): List<User>

    @Insert
    fun insertUser(user: User)

    @Update
    fun updateUser(user: User)

    @Delete
    fun deleteUser(user: User)
}