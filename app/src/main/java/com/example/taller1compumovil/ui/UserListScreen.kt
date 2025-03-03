package com.example.taller1compumovil.ui 

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberImagePainter
import com.example.taller1compumovil.model.User
import com.example.taller1compumovil.viewmodel.UserViewModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun UserListScreen(userViewModel: UserViewModel = viewModel()) {
    val users by userViewModel.users
    Scaffold(topBar = { TopAppBar(title = { Text("Lista de Usuarios") }) }) { paddingValues ->
        if (users.isEmpty()) {
            CircularProgressIndicator(modifier = Modifier.fillMaxSize())
        } else {
            LazyColumn(
                state = rememberLazyListState(),
                modifier = Modifier.padding(paddingValues)  // ⬅️ Solución aquí
            ) {
                // StickyHeader con el total de usuarios
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
                // Lista de usuarios
                items(users) { user ->
                    UserItem(user)
                }
            }
        }
    }
}

@Composable
fun UserItem(user: User) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = 4.dp
    ) {
        Row(modifier = Modifier.padding(16.dp)) {
            Image(
                painter = rememberImagePainter(user.image),
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
