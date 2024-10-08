package com.example.rfi.database.Api

data class YourRequestModel (
    val param1: String,
    val param2: String
)

data class YourResponseModel(
    val userRole: String,
    val otherData: String
)