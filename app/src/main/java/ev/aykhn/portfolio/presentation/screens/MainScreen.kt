package ev.aykhn.portfolio.presentation.screens

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import ev.aykhn.portfolio.presentation.Router
import ev.aykhn.portfolio.presentation.ui.components.AppBar
import ev.aykhn.portfolio.presentation.ui.components.DrawerItem
import ev.aykhn.portfolio.presentation.ui.components.DrawerTopBar
import ev.aykhn.portfolio.presentation.ui.theme.Black
import ev.aykhn.portfolio.presentation.ui.theme.Vulcan1
import kotlinx.coroutines.launch

@Composable
fun MainScreen() {
    val systemUiController = rememberSystemUiController()
    val useDarkIcons = false // MaterialTheme.colors.isLight

    SideEffect {
        systemUiController.setSystemBarsColor(
            color = Vulcan1,
            darkIcons = useDarkIcons
        )
    }

    val navigationController = rememberNavController()

    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()

    val currentBackStackEntry by navigationController.currentBackStackEntryAsState()
    val currentScreen = currentBackStackEntry?.destination?.route

    fun navigateAndCloseDrawer(route: String) {
        coroutineScope.launch {
            scaffoldState.drawerState.close()
        }.invokeOnCompletion {
            navigationController.navigate(route)
        }
    }

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            AppBar {
                coroutineScope.launch {
                    scaffoldState.drawerState.open()
                }
            }
        },
        drawerBackgroundColor = MaterialTheme.colors.background,
        drawerScrimColor = Black.copy(alpha = 0.8f),
        //TODO move to strings.xml
        drawerContent = {
            DrawerTopBar()
            DrawerItem(
                route = Router.SCREEN_STORYBOARD,
                isSelected = currentScreen == Router.SCREEN_STORYBOARD,
                onClick = ::navigateAndCloseDrawer,
            )
            DrawerItem(
                route = Router.SCREEN_ABOUT_ME,
                isSelected = currentScreen == Router.SCREEN_ABOUT_ME,
                onClick = ::navigateAndCloseDrawer,
            )
        },
        content = { paddingValues ->
            NavigationHost(
                paddingValues = paddingValues,
                navigationController = navigationController,
            )
        }
    )
}

@Composable
fun NavigationHost(paddingValues: PaddingValues, navigationController: NavHostController) {
    NavHost(
        navController = navigationController,
        startDestination = Router.INITIAL_SCREEN,
        modifier = Modifier.padding(paddingValues),
    ) {
        composable(Router.SCREEN_STORYBOARD) { HomeScreen(navigationController) }
        composable(Router.SCREEN_ABOUT_ME) { AboutMeScreen() }
        composable(Router.SCREEN_BLOG) { BlogScreen() }
    }
}