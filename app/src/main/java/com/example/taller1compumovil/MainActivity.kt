package com.example.taller1compumovil

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable
import com.example.taller1compumovil.ui.UserListScreen
import com.example.taller1compumovil.ui.UserDetailScreen
import com.example.taller1compumovil.viewmodel.UserViewModel
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.example.taller1compumovil.ui.theme.Taller1CompumovilTheme
import androidx.appcompat.app.AppCompatDelegate

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        setContent {
            Taller1CompumovilTheme {
                val navController = rememberNavController()
                val userViewModel: UserViewModel = viewModel() // ⬅️ Inicializar el ViewModel
                Surface {
                    NavHost(navController = navController, startDestination = "userList") {
                        composable("userList") {
                            UserListScreen(navController, userViewModel) // ⬅️ Pasar ViewModel
                        }
                        composable(
                            "userDetail/{userId}",
                            arguments = listOf(navArgument("userId") { type = NavType.IntType })
                        ) { backStackEntry ->
                            val userId = backStackEntry.arguments?.getInt("userId") ?: return@composable
                            val user = userViewModel.users.value.find { it.id == userId }
                            user?.let { UserDetailScreen(it) } // ⬅️ Solo mostrar si el usuario existe
                        }
                    }
                }
            }
        }
    }
}
