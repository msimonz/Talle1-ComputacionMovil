package com.example.taller1compumovil.model

data class UserResponse(val users: List<User>)

data class User(
    val id: Int,
    val firstName: String,
    val lastName: String,
    val image: String,
    val company: Company
)

data class Company(val name: String)

