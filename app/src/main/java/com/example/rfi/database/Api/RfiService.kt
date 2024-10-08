package com.example.rfi.database.Api

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface RfiService {
    @POST("RFIService.asmx")
    fun fetchUserData(@Body request: YourRequestModel): Call<YourResponseModel>
}