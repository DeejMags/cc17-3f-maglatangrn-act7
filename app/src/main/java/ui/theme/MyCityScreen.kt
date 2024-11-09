package ui.theme

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.mycityapp.ui.theme.CityViewModel
import com.example.mycityapp.ui.theme.DetailsScreen
import com.example.mycityapp.ui.theme.ReccomendationScreen
import com.example.mycityapp.ui.theme.StartScreen

enum class MyCityScreen(@StringRes val title: Int) {
    Start(title = R.string.app_name),
    Reccomendation(title = R.string.reccomendation),
    Details(title = R.string.details)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CityAppBar(
    title: String,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    CenterAlignedTopAppBar(
        title = { Text(title) },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        modifier = modifier,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.back_button)
                    )
                }
            }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyCityApp(
    viewModel: CityViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
) {
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = MyCityScreen.valueOf(
        backStackEntry?.destination?.route ?: MyCityScreen.Start.name
    )
    val uiState by viewModel.uiState.collectAsState()
    val title = when(currentScreen) {
        MyCityScreen.Start -> stringResource(currentScreen.title)
        MyCityScreen.Reccomendation -> stringResource(uiState.currentCategory.name)
        MyCityScreen.Details -> stringResource(uiState.currentReccomendation.title)
    }

    Scaffold(
        topBar = {
            CityAppBar(
                title = title,
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() }
            )
        }
    ) { innerPadding ->

        NavHost(
            navController = navController,
            startDestination = MyCityScreen.Start.name,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(route = MyCityScreen.Start.name) {
                StartScreen(
                    uiState = uiState,
                    onCategoryClicked = {
                        viewModel.updateCurrentCategory(it)
                        navController.navigate(MyCityScreen.Reccomendation.name)
                    },
                )
            }
            composable(route = MyCityScreen.Reccomendation.name) {
                ReccomendationScreen(
                    uiState = uiState,
                    onReccomendationClicked = {
                        viewModel.updateCurrentReccomendation(it)
                        navController.navigate(MyCityScreen.Details.name)
                    }
                )
            }
            composable(route = MyCityScreen.Details.name) {
                DetailsScreen(
                    uiState = uiState,
                )
            }
        }
    }
}