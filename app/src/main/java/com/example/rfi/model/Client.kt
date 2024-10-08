package com.example.rfi.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Client")
data class Client(
    @PrimaryKey
    val Client_ID: String,
    val Clnt_Name: String,
    val CL_Dispaly_Name: String,
    val Clnt_Adrs: String,
    val user_id: String
)
