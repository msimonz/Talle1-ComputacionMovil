package com.example.taller1compumovil.network
import com.example.taller1compumovil.model.UserResponse

import retrofit2.http.GET

interface ApiService {
    @GET("users")
    suspend fun getUsers(): UserResponse
}
