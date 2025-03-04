package com.example.taller1compumovil.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel

class ThemeViewModel : ViewModel() {
    // Variable para manejar el estado del tema (oscuro o claro)
    var isDarkMode = mutableStateOf(false)

    // Método para cambiar el estado del tema
    fun toggleTheme() {
        isDarkMode.value = !isDarkMode.value
    }
}
