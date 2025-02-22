package dev.carrion.koinruntime.presentation.home

data class HomeState(
    val isLoading: Boolean = false,
    val content: String = "Press button to load greeting",
    val error: String? = null
)
