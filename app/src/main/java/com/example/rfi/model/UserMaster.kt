package com.example.rfi.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "userMaster")
data class UserMaster(
    @PrimaryKey(autoGenerate = true)
    val Pk_User_ID: Int = 0,
    val User_Name: String,
    val Password: String,
    val user_role: String,
    val dashboardroll: String
)
