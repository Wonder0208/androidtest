package com.swapi.app.presentation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Movie
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Public
import androidx.compose.material.icons.filled.RocketLaunch
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.swapi.app.presentation.films.FilmDetailScreen
import com.swapi.app.presentation.films.FilmsScreen
import com.swapi.app.presentation.navigation.Screen
import com.swapi.app.presentation.people.PeopleScreen
import com.swapi.app.presentation.people.PersonDetailScreen
import com.swapi.app.presentation.planets.PlanetDetailScreen
import com.swapi.app.presentation.planets.PlanetsScreen
import com.swapi.app.presentation.starships.StarshipDetailScreen
import com.swapi.app.presentation.starships.StarshipsScreen

private data class BottomNavItem(val screen: Screen, val label: String, val icon: ImageVector)

private val bottomNavItems = listOf(
    BottomNavItem(Screen.People, "Characters", Icons.Default.Person),
    BottomNavItem(Screen.Planets, "Planets", Icons.Default.Public),
    BottomNavItem(Screen.Films, "Films", Icons.Default.Movie),
    BottomNavItem(Screen.Starships, "Starships", Icons.Default.RocketLaunch)
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SwapiApp() {
    val navController = rememberNavController()
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = backStackEntry?.destination?.route

    val isTopLevel = bottomNavItems.any { it.screen.route == currentRoute }
    val title = when {
        currentRoute?.startsWith("person/") == true -> "Character Detail"
        currentRoute?.startsWith("planet/") == true -> "Planet Detail"
        currentRoute?.startsWith("film/") == true -> "Film Detail"
        currentRoute?.startsWith("starship/") == true -> "Starship Detail"
        else -> bottomNavItems.firstOrNull { it.screen.route == currentRoute }?.label ?: "Star Wars"
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(title) },
                navigationIcon = {
                    if (!isTopLevel) {
                        IconButton(onClick = { navController.popBackStack() }) {
                            Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                        }
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                    navigationIconContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )
        },
        bottomBar = {
            NavigationBar {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination
                bottomNavItems.forEach { item ->
                    NavigationBarItem(
                        icon = { Icon(item.icon, contentDescription = item.label) },
                        label = { Text(item.label) },
                        selected = currentDestination?.hierarchy?.any { it.route == item.screen.route } == true,
                        onClick = {
                            navController.navigate(item.screen.route) {
                                popUpTo(navController.graph.findStartDestination().id) { saveState = true }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    )
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.People.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Screen.People.route) {
                PeopleScreen(onPersonClick = { id ->
                    navController.navigate(Screen.PersonDetail.createRoute(id))
                })
            }
            composable(
                route = Screen.PersonDetail.route,
                arguments = listOf(navArgument("personId") { type = NavType.IntType })
            ) {
                PersonDetailScreen()
            }
            composable(Screen.Planets.route) {
                PlanetsScreen(onPlanetClick = { id ->
                    navController.navigate(Screen.PlanetDetail.createRoute(id))
                })
            }
            composable(
                route = Screen.PlanetDetail.route,
                arguments = listOf(navArgument("planetId") { type = NavType.IntType })
            ) {
                PlanetDetailScreen()
            }
            composable(Screen.Films.route) {
                FilmsScreen(onFilmClick = { id ->
                    navController.navigate(Screen.FilmDetail.createRoute(id))
                })
            }
            composable(
                route = Screen.FilmDetail.route,
                arguments = listOf(navArgument("filmId") { type = NavType.IntType })
            ) {
                FilmDetailScreen()
            }
            composable(Screen.Starships.route) {
                StarshipsScreen(onStarshipClick = { id ->
                    navController.navigate(Screen.StarshipDetail.createRoute(id))
                })
            }
            composable(
                route = Screen.StarshipDetail.route,
                arguments = listOf(navArgument("starshipId") { type = NavType.IntType })
            ) {
                StarshipDetailScreen()
            }
        }
    }
}
