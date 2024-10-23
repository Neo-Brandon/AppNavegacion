package com.example.navegacion.views

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.navegacion.R
import com.example.navegacion.components.MainIconButton
import com.example.navegacion.components.TitleBar

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
//@Composable@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DogYear(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { TitleBar(name = "Años Perrunos") },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = Color.DarkGray
                ),
                navigationIcon = {
                    MainIconButton(icon = Icons.Default.ArrowBack) {
                        navController.popBackStack()
                    }
                }
            )
        }
    ) {
        ContentDogYearView(navController)
    }
}

@Composable
fun ContentDogYearView(navController: NavController) {
    PosicionPantalla(
        titulo = "Mis Años Perrunos",
        imagen = painterResource(id = R.drawable.perrunos)
    )
}

@Composable
private fun PosicionPantalla(titulo: String, imagen: Painter, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center, // Centra el contenido verticalmente
        horizontalAlignment = Alignment.CenterHorizontally // Centra el contenido horizontalmente
    ) {
        var edad by remember { mutableStateOf("") }
        var resultado by remember { mutableStateOf("") }

        // Agregar un espacio entre la imagen y el margen superior
        Spacer(modifier = Modifier.height(20.dp))

        Image(
            painter = imagen,
            contentDescription = null,
            contentScale = ContentScale.FillHeight,
            alignment = Alignment.Center,
            modifier = Modifier.size(200.dp) // Ajusta el tamaño de la imagen si es necesario
        )

        Spacer(modifier = Modifier.height(20.dp)) // Espacio entre la imagen y el título

        Text(
            text = titulo,
            modifier = Modifier.padding(16.dp),
            textAlign = TextAlign.Center,
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Cursive
        )

        Spacer(modifier = Modifier.height(20.dp)) // Espacio entre el título y el primer input

        OutlinedTextField(
            value = edad,
            onValueChange = { edad = it },
            label = { Text("Mi edad humana") },
            modifier = Modifier.fillMaxWidth() // Esto hará que el campo ocupe todo el ancho disponible
        )

        Spacer(modifier = Modifier.height(20.dp)) // Espacio entre los inputs

        ElevatedButton(
            onClick = {
                var res = 0
                res = edad.toInt() * 7
                resultado = res.toString()
            },
            modifier = Modifier.fillMaxWidth() // Botón centrado
        ) {
            Text("Calcular")
        }

        Spacer(modifier = Modifier.height(20.dp)) // Espacio entre el botón y el segundo input

        OutlinedTextField(
            value = resultado,
            readOnly = true,
            onValueChange = { resultado = it },
            label = { Text("Edad Perruna") },
            modifier = Modifier.fillMaxWidth() // Este campo también ocupa todo el ancho
        )
    }
}
