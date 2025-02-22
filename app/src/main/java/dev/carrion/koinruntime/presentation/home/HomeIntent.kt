package dev.carrion.koinruntime.presentation.home

sealed interface HomeIntent {
    data object GetGreeting : HomeIntent
}
