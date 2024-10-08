package com.example.rfi.database.repository

import com.example.rfi.database.Api.RfiService
import com.example.rfi.database.Api.YourRequestModel
import com.example.rfi.database.Api.YourResponseModel
import com.example.rfi.model.Client
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RfiRepository  constructor(
    private val rfiService: RfiService
){

    // Method to fetch user data
    fun fetchUserData(
        requestModel: YourRequestModel,
        onSuccess: (YourResponseModel) -> Unit,
        onError: (String) -> Unit
    ) {
        val call = rfiService.fetchUserData(requestModel)
        call.enqueue(object : Callback<YourResponseModel> {
            override fun onResponse(
                call: Call<YourResponseModel>,
                response: Response<YourResponseModel>
            ) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        onSuccess(it) // Pass the response to the success callback
                    } ?: onError("Response body is null")
                } else {
                    onError("Error: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<YourResponseModel>, t: Throwable) {
                onError("Failure: ${t.message ?: "Unknown error"}")
            }
        })
    }

    // You can add more methods for fetching other data as needed
    // For example:
    fun fetchClients(onSuccess: (List<Client>) -> Unit, onError: (String) -> Unit) {
        val call = rfiService.fetchClients()
        call.enqueue(object : Callback<List<Client>> {
            override fun onResponse(call: Call<List<Client>>, response: Response<List<Client>>) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        onSuccess(it) // Pass the list of clients to the success callback
                    } ?: onError("Response body is null")
                } else {
                    onError("Error: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<List<Client>>, t: Throwable) {
                onError("Failure: ${t.message ?: "Unknown error"}")
            }
        })
    }

    // Similarly, you can implement other methods for fetching schemes or other entities
}