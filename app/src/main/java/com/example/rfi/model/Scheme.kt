package com.example.rfi.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Scheme")
data class Scheme(
    @PrimaryKey
    val PK_Scheme_ID: String,
    val Scheme_Name: String,
    val Scheme_Cl_Id: String,
    val Scheme_Diplay_Name: String,
    val Scheme_Adrs: String,
    val Scheme_Region: String,
    val scrolling_status: String,
    val user_id: String
)
