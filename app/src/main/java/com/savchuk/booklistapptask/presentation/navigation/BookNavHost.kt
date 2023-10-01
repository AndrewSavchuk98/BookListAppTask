package com.savchuk.booklistapptask.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.savchuk.booklistapptask.presentation.screens.books.BookScreen
import com.savchuk.booklistapptask.presentation.screens.categories.CategoriesScreen

@Composable
fun BookNavHost(
    modifier: Modifier = Modifier,
) {
    val navController: NavHostController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.CategoryScreen.route) {
        composable(Screen.CategoryScreen.route) {
            CategoriesScreen(modifier = modifier, onCardClick = {
                navController.navigate("${Screen.BookScreen.route}/$it")
            })
        }
        composable("${Screen.BookScreen.route}/{listName}",
            arguments = listOf(
                navArgument("listName") {
                    type = NavType.StringType
                }
            )
        ) {
            BookScreen(modifier = modifier)
        }
    }
}

sealed class Screen(val route: String) {
    object CategoryScreen : Screen("category")
    object BookScreen : Screen("book")
}