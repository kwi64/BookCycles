package com.csis4175.bookcycles.ui

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.csis4175.bookcycles.R
import com.csis4175.bookcycles.ui.screens.available_books.AvailableBooksScreen
import com.csis4175.bookcycles.ui.screens.get_this_book.GetThisBookScreen
import com.csis4175.bookcycles.ui.screens.nearby_locations.NearbyLocationsScreen
import com.csis4175.bookcycles.ui.screens.login.LoginScreen
import com.csis4175.bookcycles.ui.screens.my_books.MyBooksScreen
import com.csis4175.bookcycles.ui.screens.register.RegisterScreen
import com.csis4175.bookcycles.ui.screens.share_book.ShareBookScreen
import com.csis4175.bookcycles.ui.screens.visitors.VisitorsScreen

enum class BookCyclesScreen(@StringRes val title: Int) {
    Login(title = R.string.book_cycles_screen_title),
    Register(title = R.string.register_screen_title),
    NearbyLocations(title = R.string.nearby_book_locations_screen_title),
    ShareBook(title = R.string.share_a_book_screen_title),
    MyBooks(title = R.string.my_shared_books_screen_title),
    Visitors(title = R.string.scheduled_visitors_screen_title),
    AvailableBooks(title = R.string.available_books_screen_title),
    GetThisBook(title = R.string.get_this_book_screen_title),
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
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() },
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
            // BOOK CYCLES (login page)
            composable(route = BookCyclesScreen.Login.name) {
                LoginScreen(
                    onLoginButtonClicked = {
                        navController.navigate(BookCyclesScreen.NearbyLocations.name){
                            popUpTo(navController.graph.startDestinationId) {
                                inclusive = true
                            }
                        }
                    },
                    onRegisterButtonClicked = {
                        navController.navigate(BookCyclesScreen.Register.name)
                    }
                )
            }
            // REGISTER a new user page
            composable(route = BookCyclesScreen.Register.name) {
                RegisterScreen(
                    onCompleteRegistrationButtonClicked = {
                        navController.navigate(BookCyclesScreen.NearbyLocations.name){
                            popUpTo(navController.graph.startDestinationId) {
                                inclusive = true
                            }
                        }
                    }
                )
            }
            // NEARBY BOOK LOCATIONS (main home page)
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
            // SHARE A BOOK page
            composable(route = BookCyclesScreen.ShareBook.name) {
                ShareBookScreen(
                    onShareThisBookButtonClicked = {
                        navController.navigate(BookCyclesScreen.MyBooks.name)
                    }
                )
            }
            // MY SHARED BOOKS (books you personally have shared for others)
            composable(route = BookCyclesScreen.MyBooks.name) {
                MyBooksScreen(
                    onMyBookClicked = {
                        navController.navigate(BookCyclesScreen.Visitors.name)
                    }
                )
            }
            // SCHEDULED VISITORS
            composable(route = BookCyclesScreen.Visitors.name) {
                VisitorsScreen()
            }
            // AVAILABLE BOOKS at a specific location
            composable(route = BookCyclesScreen.AvailableBooks.name) {
                AvailableBooksScreen(
                    onAvailableBookClicked = {
                        navController.navigate(BookCyclesScreen.GetThisBook.name)
                    }
                )
            }
            // GET THIS BOOK page
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
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
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
                text = stringResource(currentScreen.title),
                style = MaterialTheme.typography.headlineSmall,
            )
        },
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Back Button"
                    )
                }
            }
        },
        modifier = modifier
    )
}