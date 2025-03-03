package com.example.taller1compumovil.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.State
import com.example.taller1compumovil.model.User
import com.example.taller1compumovil.network.ApiClient

class UserViewModel : ViewModel() {
    private val _users = mutableStateOf<List<User>>(emptyList())
    val users: State<List<User>> = _users

    init {
        fetchUsers()
    }

    private fun fetchUsers() {
        viewModelScope.launch {
            try {
                val response = ApiClient.apiService.getUsers()
                _users.value = response.users
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}

