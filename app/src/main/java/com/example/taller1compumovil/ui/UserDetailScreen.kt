package com.example.taller1compumovil.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.taller1compumovil.model.User
import coil.compose.rememberAsyncImagePainter


@Composable
fun UserDetailScreen(user: User) {
    Scaffold(topBar = { TopAppBar(title = { Text("${user.firstName} ${user.lastName}") }) }) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            Image(
                painter = rememberAsyncImagePainter(user.image),
                contentDescription = "Imagen de perfil",
                modifier = Modifier.size(150.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "Nombre: ${user.firstName} ${user.lastName}", style = MaterialTheme.typography.h6)
            Text(text = "Teléfono: ${user.phone}", style = MaterialTheme.typography.body1)
            Text(text = "Correo: ${user.email}", style = MaterialTheme.typography.body1)
            Text(text = "Género: ${user.gender}", style = MaterialTheme.typography.body1)
            Text(text = "Ciudad: ${user.address.city}", style = MaterialTheme.typography.body1)
            Text(text = "Estado: ${user.address.state}", style = MaterialTheme.typography.body1)
            Text(text = "Empresa: ${user.company.name}", style = MaterialTheme.typography.body1)
            Text(text = "Sitio Web: ${user.domain}", style = MaterialTheme.typography.body1)
            Text(text = "IP: ${user.ip}", style = MaterialTheme.typography.body1)
            Text(text = "Universidad: ${user.university}", style = MaterialTheme.typography.body1)
        }
    }
}
