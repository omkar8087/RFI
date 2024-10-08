package com.example.rfi.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.rfi.model.Client
import com.example.rfi.model.Scheme
import com.example.rfi.model.UserMaster

@Dao
interface RfiDao {

    //Insert User
    @Insert
    suspend fun insertUser(userMaster: UserMaster)

    // Get User by ID
    @Query("SELECT * FROM userMaster WHERE Pk_User_ID = :id")
    suspend fun getUserById(id:Int): UserMaster?

    // Insert Client
    @Insert
    suspend fun insertClient(client: Client)

    // Get all Clients
    @Query("SELECT * FROM Client")
    suspend fun getAllClients(): List<Client>

    //Insert scheme
    @Insert
    suspend fun insertScheme(scheme: Scheme)


    @Query("SELECT * FROM Scheme WHERE Scheme_Cl_Id = :clientId")
    suspend fun getSchemesByClientId(clientId: String): List<Scheme>
}