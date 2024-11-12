package com.csis4175.bookcycles.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.csis4175.bookcycles.ui.screens.available_books.AvailableBooksScreen
import com.csis4175.bookcycles.ui.screens.get_this_book.GetThisBookScreen
import com.csis4175.bookcycles.ui.screens.nearby_locations.NearbyLocationsScreen
import com.csis4175.bookcycles.ui.screens.login.LoginScreen
import com.csis4175.bookcycles.ui.screens.my_books.MyBooksScreen
import com.csis4175.bookcycles.ui.screens.register.RegisterScreen
import com.csis4175.bookcycles.ui.screens.share_book.ShareBookScreen
import com.csis4175.bookcycles.ui.screens.visitors.VisitorsScreen

enum class BookCyclesScreen(val title: String) {
    Login("BOOK CYCLES"),
    Register("REGISTER"),
    NearbyLocations("NEARBY BOOK LOCATIONS"),
    ShareBook("SHARE A BOOK"),
    MyBooks("MY SHARED BOOKS"),
    Visitors("SCHEDULED VISITORS"),
    AvailableBooks("AVAILABLE BOOKS"),
    GetThisBook("GET THIS BOOK"),
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookCyclesApp(navController: NavHostController = rememberNavController()) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = BookCyclesScreen.valueOf(
        backStackEntry?.destination?.route ?: BookCyclesScreen.Login.name
    )

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            BookCyclesTopAppBar(
                scrollBehavior = scrollBehavior,
                currentScreen = currentScreen
            )
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = BookCyclesScreen.Login.name,
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(innerPadding)
        ) {
            composable(route = BookCyclesScreen.Login.name) {
                LoginScreen(
                    onLoginButtonClicked = {
                        navController.navigate(BookCyclesScreen.NearbyLocations.name)
                    },
                    onRegisterButtonClicked = {
                        navController.navigate(BookCyclesScreen.Register.name)
                    }
                )
            }
            composable(route = BookCyclesScreen.Register.name) {
                RegisterScreen(
                    onCompleteRegistrationButtonClicked = {
                        navController.navigate(BookCyclesScreen.NearbyLocations.name)
                    }
                )
            }
            composable(route = BookCyclesScreen.NearbyLocations.name) {
                NearbyLocationsScreen(
                    onLocationClicked = {
                        navController.navigate(BookCyclesScreen.AvailableBooks.name)
                    },
                    onShareBookButtonClicked = {
                        navController.navigate(BookCyclesScreen.ShareBook.name)
                    },
                    onMyBooksButtonClicked = {
                        navController.navigate(BookCyclesScreen.MyBooks.name)
                    }
                )
            }
            composable(route = BookCyclesScreen.ShareBook.name) {
                ShareBookScreen(
                    onShareThisBookButtonClicked = {
                        navController.navigate(BookCyclesScreen.MyBooks.name)
                    }
                )
            }
            composable(route = BookCyclesScreen.MyBooks.name) {
                MyBooksScreen(
                    onMyBookClicked = {
                        navController.navigate(BookCyclesScreen.Visitors.name)
                    }
                )
            }
            composable(route = BookCyclesScreen.Visitors.name) {
                VisitorsScreen()
            }
            composable(route = BookCyclesScreen.AvailableBooks.name){
                AvailableBooksScreen(
                    onAvailableBookClicked = {
                        navController.navigate(BookCyclesScreen.GetThisBook.name)
                    }
                )
            }
            composable(route = BookCyclesScreen.GetThisBook.name) {
                GetThisBookScreen()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookCyclesTopAppBar(
    scrollBehavior: TopAppBarScrollBehavior,
    currentScreen: BookCyclesScreen,
    modifier: Modifier = Modifier
) {
    CenterAlignedTopAppBar(
        scrollBehavior = scrollBehavior,
        colors = topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.onPrimary,
        ),
        title = {
            Text(
                text = currentScreen.title,
                style = MaterialTheme.typography.headlineSmall,
            )
        },
        modifier = modifier
    )
}