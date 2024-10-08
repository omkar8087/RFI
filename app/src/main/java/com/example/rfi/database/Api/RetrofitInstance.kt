package com.example.rfi.database.Api

import retrofit2.Retrofit
import retrofit2.converter.simplexml.SimpleXmlConverterFactory
import retrofit2.create


object RetrofitInstance{
    private const val Base_URL = "https://www.cqra-rfi.com/RFIYZPSafety_20240228Service/"

    val api: RfiService by lazy {
        Retrofit.Builder()
            .baseUrl(Base_URL)
            .addConverterFactory(SimpleXmlConverterFactory.create())
            .build()
            .create(RfiService::class.java)
    }
}