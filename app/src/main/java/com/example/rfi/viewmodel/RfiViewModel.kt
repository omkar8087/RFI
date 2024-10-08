package com.example.rfi.viewmodel



import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rfi.database.Api.RetrofitInstance
import com.example.rfi.database.Api.YourRequestModel
import com.example.rfi.database.Api.YourResponseModel
import kotlinx.coroutines.launch
import com.example.rfi.database.RfiDao
import com.example.rfi.model.Client
import com.example.rfi.model.Scheme
import com.example.rfi.model.UserMaster

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class RfiViewModel  constructor(
    private val dao: RfiDao
): ViewModel() {

    suspend fun insertUser(user: UserMaster){
        dao.insertUser(user)
    }

    suspend fun getUserById(id: Int): UserMaster? {
        return dao.getUserById(id)
    }

    suspend fun insertClient(client: Client){
        dao.insertClient(client)
    }

    suspend fun getAllClients(): List<Client> {
        return dao.getAllClients()
    }

    suspend fun insertScheme(scheme: Scheme){
        dao.insertScheme(scheme)
    }

    suspend fun getSchemesByClientId(clientId: String): List<Scheme>{
        return dao.getSchemesByClientId(clientId)
    }

    fun fetchUserData(requestModel: YourRequestModel, onRoleReceived: (String) -> Unit) {
        val call = RetrofitInstance.api.fetchUserData(requestModel)

        call.enqueue(object : Callback<YourResponseModel> {
            override fun onResponse(
                call: Call<YourResponseModel>,
                response: Response<YourResponseModel>
            ) {
                if (response.isSuccessful) {
                    val userRole = response.body()?.userRole ?: ""
                    onRoleReceived(userRole)
                }
            }

            override fun onFailure(call: Call<YourResponseModel>, t: Throwable) {
                TODO("Not yet implemented")
            }


        })


    }
}