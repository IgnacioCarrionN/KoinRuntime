package dev.carrion.koinruntime.di

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import dev.carrion.koinruntime.domain.GetGreetingUseCase
import dev.carrion.koinruntime.presentation.home.HomeViewModel

fun provideViewModelFactory(useCase: GetGreetingUseCase): ViewModelProvider.Factory =
    viewModelFactory {
        initializer {
            HomeViewModel(useCase)
        }
    }

fun provideViewModel(viewModelStoreOwner: ViewModelStoreOwner): HomeViewModel =
    ViewModelProvider.create(
        owner = viewModelStoreOwner,
        factory = provideViewModelFactory(
            provideGetGreetingUseCase(
                provideGreetingRepository(
                    provideGreetingDataSource(
                        provideLocalGreetingProvider()
                    )
                )
            )
        ),
        extras = CreationExtras.Empty
    )[HomeViewModel::class]
