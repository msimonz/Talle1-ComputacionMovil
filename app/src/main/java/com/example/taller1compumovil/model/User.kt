package com.example.taller1compumovil.model

data class UserResponse(val users: List<User>)

data class User(
    val id: Int,
    val firstName: String,
    val lastName: String,
    val image: String,
    val phone: String,
    val email: String,
    val gender: String,
    val address: Address,
    val company: Company,
    val domain: String,
    val ip: String,
    val university: String
)

data class Address(
    val city: String,
    val state: String
)
data class Company(val name: String)

