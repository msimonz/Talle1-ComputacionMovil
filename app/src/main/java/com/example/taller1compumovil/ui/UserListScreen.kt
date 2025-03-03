package com.example.taller1compumovil.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberImagePainter
import com.example.taller1compumovil.model.User
import com.example.taller1compumovil.viewmodel.UserViewModel
import androidx.navigation.NavController
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter



@OptIn(ExperimentalFoundationApi::class)
@Composable
fun UserListScreen(navController: NavController, userViewModel: UserViewModel = viewModel()) {
    val users by userViewModel.users

    Scaffold(topBar = { TopAppBar(title = { Text("Lista de Usuarios") }) }) { paddingValues ->
        if (users.isEmpty()) {
            CircularProgressIndicator(modifier = Modifier.fillMaxSize())
        } else {
            LazyColumn(
                state = rememberLazyListState(),
                modifier = Modifier.padding(paddingValues)
            ) {
                stickyHeader {
                    Surface(
                        modifier = Modifier.fillMaxWidth(),
                        color = MaterialTheme.colors.primary
                    ) {
                        Text(
                            text = "Total de usuarios: ${users.size}",
                            modifier = Modifier.padding(16.dp),
                            style = MaterialTheme.typography.h6,
                            color = MaterialTheme.colors.onPrimary
                        )
                    }
                }

                items(users) { user ->
                    UserItem(user) {
                        navController.navigate("userDetail/${user.id}")
                    }
                }
            }
        }
    }
}

@Composable
fun UserItem(user: User, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onClick() },  // ⬅️ Navega al hacer clic
        elevation = 4.dp
    ) {
        Row(modifier = Modifier.padding(16.dp)) {
            Image(
                painter = rememberAsyncImagePainter(user.image),
                contentDescription = "Imagen de perfil",
                modifier = Modifier.size(50.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(text = "${user.firstName} ${user.lastName}", style = MaterialTheme.typography.h6)
                Text(text = "Empresa: ${user.company.name}", style = MaterialTheme.typography.body2)
            }
        }
    }
}
