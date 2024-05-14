package com.norm.mynewnavigationcompose.presentation

import androidx.compose.runtime.Composable
import androidx.lifecycle.Lifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.norm.mynewnavigationcompose.presentation.screen.HomeScreen
import com.norm.mynewnavigationcompose.presentation.screen.ProfileScreen
import kotlin.random.Random
import kotlin.random.nextInt

@Composable
fun SetupNavGraph(
    navController: NavHostController,
    startDestination: Screen = Screen.Home,
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
    ) {
        composable<Screen.Home> {
            HomeScreen(
                onClick = {
                    navController.navigate(
                        Screen.Profile(id = Random.nextInt(0..10))
                    )
                }
            )
        }
        composable<Screen.Profile> { backStackEntry ->
            val profile = backStackEntry.toRoute<Screen.Profile>()
            ProfileScreen(
                id = profile.id,
                onClick = {
                    if (navController.canGoBack) {
                        navController.popBackStack()
                    }
                }
            )
        }
    }
}

val NavHostController.canGoBack: Boolean
    get() = this.currentBackStackEntry?.lifecycle?.currentState == Lifecycle.State.RESUMED
