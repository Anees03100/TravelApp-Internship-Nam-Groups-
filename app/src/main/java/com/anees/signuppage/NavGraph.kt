package com.anees.signuppage

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun Nav() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "dashboard_screen",
    ) {
        composable (route = "dashboard_screen"){
        Dashboard(navController = navController)
        }
        composable(route = "main_screen") {
            Main(navController = navController)
        }
        composable(route = "login_screen"){
            LoginScreen(navController = navController)
        }
        composable(route = "mainn_screen"){
            MainScreen(navController = navController)
        }
        composable (route = "calculator_page"){
            Calculator(navController = navController)
        }

        composable(
            route = "screen_a/{name}/{email}/{gender}/{hobbies}",
            arguments = listOf(
                navArgument("name") { type = NavType.StringType },
                navArgument("email") { type = NavType.StringType },
                navArgument("gender") { type = NavType.StringType },
                navArgument("hobbies") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val userName = backStackEntry.arguments?.getString("name") ?: "No Name"
            val userEmail = backStackEntry.arguments?.getString("email") ?: "No Email"
            val userGender = backStackEntry.arguments?.getString("gender") ?: "Not Specified"
            val userHobbies = backStackEntry.arguments?.getString("hobbies") ?: "None"
            ScreenA(
                name = userName, email = userEmail, gender = userGender, hobbies = userHobbies,navController = navController
            )
        }
    }
}