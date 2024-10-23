package com.example.navegacion.views

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.navegacion.components.MainIconButton
import com.example.navegacion.components.TitleBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PrecioDescuento(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { TitleBar(name = "Precio Descuento") },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = Color.Red
                ),
                navigationIcon = {
                    MainIconButton(icon = Icons.Default.ArrowBack) {
                        navController.popBackStack()
                    }
                }
            )
        }
    ) { paddingValues ->  // Uso paddingValues para evitar superposición
                          // Con la navBar
        ContentPrecioDescuento(navController, paddingValues)
    }
}

@Composable
fun ContentPrecioDescuento(navController: NavController, paddingValues: PaddingValues) {
    PosicionPantalla(
        titulo = "Calculadora de descuento Neo",
        modifier = Modifier.padding(paddingValues)  // Respetar el padding del Scaffold
    )
}

@Composable
private fun PosicionPantalla(titulo: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.padding(50.dp)
    ) {
        var precio by remember { mutableStateOf("") }
        var descuento by remember { mutableStateOf("") }
        var resultado by remember { mutableStateOf("") }
        var resultado1 by remember { mutableStateOf("") }

        Text(
            text = titulo,
            modifier = Modifier.padding(16.dp),
            textAlign = TextAlign.Center,
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.SansSerif
        )

        OutlinedTextField(
            value = precio,
            onValueChange = { precio = it },
            label = { Text("Precio base") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        OutlinedTextField(
            value = descuento,
            onValueChange = { descuento = it },
            label = { Text("% de descuento") }
        )
        Spacer(modifier = Modifier.padding(5.dp))

        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center) {
            ElevatedButton(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    // Validar que los valores introducidos sean números válidos
                    val precioDouble = precio.toDoubleOrNull()
                    val descuentoDouble = descuento.toDoubleOrNull()

                    if (precioDouble != null && descuentoDouble != null) {
                        // Cálculo del precio con el descuento aplicado
                        val descuentoAplicado =
                            precioDouble - (descuentoDouble / 100) * precioDouble
                        resultado = String.format("%.2f", descuentoAplicado)
                        val descuento = (descuentoDouble / 100) * precioDouble
                        resultado1 = String.format("%.2f", descuento)
                    } else {
                        resultado = "Entrada inválida"
                    }
                }
            ) {
                Text("Calcular")
            }
        }
        Spacer(modifier = Modifier.padding(5.dp))

        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center) {
            ElevatedButton(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    // Limpiar los campos de entrada
                    precio = ""
                    descuento = ""
                    resultado = ""
                }
            ) {
                Text("Limpiar")
            }
        }
        OutlinedTextField(
            value = resultado1,
            readOnly = true,
            onValueChange = { resultado1 = it },
            label = { Text("Descuento") }
        )

        OutlinedTextField(
            value = resultado,
            readOnly = true,
            onValueChange = { resultado = it },
            label = { Text("Precio con descuento aplicado") }
        )
    }
}

/*
@Preview(showBackground = true)
@Composable
fun ContentPreview() {
    PrecioDescuento()
}
*/