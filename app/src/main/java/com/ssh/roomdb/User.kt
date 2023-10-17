package com.ssh.roomdb

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class User(
    @PrimaryKey(autoGenerate = true)
    val id: Int?,

    @ColumnInfo(name = "userName")
    val usrName: String?,

    @ColumnInfo(name = "userAge")
    val userAge: String?
)
