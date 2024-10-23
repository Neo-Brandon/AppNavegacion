package com.example.navegacion.navigation


import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.loto.view.LoteriaView
import com.example.loto.viewModels.LoteriaViewModel
import com.example.navegacion.views.DetailsView
import com.example.navegacion.views.DogYear
import com.example.navegacion.views.HomeView
import com.example.navegacion.views.ExtraView
import com.example.navegacion.views.PrecioDescuento
import androidx.activity.viewModels

@Composable
fun NavManager(viewModel: LoteriaViewModel){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "Home"  ){
        composable("Home"){
            HomeView(navController)
        }
        composable("Detail/{id}/?{opcional}", arguments = listOf(
            navArgument("id") { type = NavType.IntType },
            navArgument("opcional") { type = NavType.StringType },
        )){
            val id = it.arguments?.getInt("id") ?: 0
            val opcional = it.arguments?.getString("opcional") ?: ""
            DetailsView(navController, id, opcional)
        }
        composable("Extra/{id}/?{opcional}", arguments = listOf(
            navArgument("id") { type = NavType.IntType },
            navArgument("opcional") { type = NavType.StringType },
        )) {
            val id = it.arguments?.getInt("id") ?: 0
            val opcional = it.arguments?.getString("opcional") ?: ""
            ExtraView(navController, id, opcional)
        }
        composable("DogYear") {
            DogYear(navController)
        }
        composable("PrecioDescuento") {
            PrecioDescuento(navController)
        }
        composable("LoteriaApp") {
            LoteriaView(navController,viewModel)
        }
    }
}
