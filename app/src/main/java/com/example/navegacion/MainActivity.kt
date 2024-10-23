package com.example.navegacion

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.loto.viewModels.LoteriaViewModel
import com.example.navegacion.navigation.NavManager
import com.example.navegacion.ui.theme.NavegacionTheme
import com.example.navegacion.views.HomeView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        // Obtén una instancia de LoteriaViewModel usando viewModels()
        val viewModel: LoteriaViewModel by viewModels()

        setContent {
            NavManager(viewModel)
        }
    }
}
