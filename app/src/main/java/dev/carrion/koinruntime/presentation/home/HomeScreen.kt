package dev.carrion.koinruntime.presentation.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import dev.carrion.koinruntime.presentation.ui.theme.KoinRuntimeTheme
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = koinViewModel(),
) {
    val state by viewModel.homeState.collectAsStateWithLifecycle()

    Home(
        state = state,
        onHomeIntent = viewModel::sendIntent
    )
}

@Composable
fun Home(
    state: HomeState,
    onHomeIntent: (HomeIntent) -> Unit
) {
    val snackbarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()

    state.error?.let {
        if (!state.isLoading) {
            coroutineScope.launch {
                val snackbarResult = snackbarHostState.showSnackbar(
                    message = it,
                    actionLabel = "Retry"
                )
                if (snackbarResult == SnackbarResult.ActionPerformed) {
                    onHomeIntent(HomeIntent.GetGreeting)
                }
            }
        } else {
            coroutineScope.launch {
                snackbarHostState.currentSnackbarData?.dismiss()
            }
        }
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        }
    ) { innerPadding ->
        Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
            Column(
                verticalArrangement = Arrangement.spacedBy(12.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = state.content,
                    modifier = Modifier.padding(innerPadding)
                )
                Button(onClick = {
                    onHomeIntent(HomeIntent.GetGreeting)
                }) {
                    Text(text = "Get Greeting")
                }
            }
            if (state.isLoading) {
                CircularProgressIndicator()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview(
    @PreviewParameter(HomeStateProvider::class) state: HomeState
) {
    KoinRuntimeTheme {
        Home(
            state = state
        ) {
            // NO-OP
        }
    }
}

class HomeStateProvider : PreviewParameterProvider<HomeState> {
    override val values = sequenceOf(
        HomeState(false, "Hello Android dev Perú", null),
        HomeState(true, "Hello Android dev Perú", null),
        HomeState(false, "Hello Android dev Perú", "Something went wrong")
    )
}
