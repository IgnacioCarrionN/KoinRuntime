package dev.carrion.koinruntime.di

import dev.carrion.koinruntime.domain.GetGreetingUseCase
import dev.carrion.koinruntime.presentation.home.HomeViewModel
import org.koin.android.annotation.KoinViewModel
import org.koin.core.annotation.Module

@Module
class PresentationModule {
    @KoinViewModel
    fun provideHomeViewModel(getGreetingUseCase: GetGreetingUseCase): HomeViewModel =
        HomeViewModel(getGreetingUseCase)
}
