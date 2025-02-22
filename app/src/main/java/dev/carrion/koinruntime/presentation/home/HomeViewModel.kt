package dev.carrion.koinruntime.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.carrion.koinruntime.domain.GetGreetingUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel(private val getGreetingUseCase: GetGreetingUseCase) : ViewModel() {
    private val state = MutableStateFlow(HomeState())
    val homeState: StateFlow<HomeState>
        get() = state.asStateFlow()

    fun sendIntent(intent: HomeIntent) {
        when (intent) {
            is HomeIntent.GetGreeting -> getGreeting()
        }
    }

    private fun getGreeting() {
        viewModelScope.launch {
            state.update { it.copy(isLoading = true) }
            getGreetingUseCase.invoke().onSuccess { content ->
                state.update { it.copy(isLoading = false, content = content, error = null) }
            }.onFailure { error ->
                state.update {
                    it.copy(
                        isLoading = false,
                        error = error.message ?: "Unknown error"
                    )
                }
            }
        }
    }

}
