package dev.carrion.koinruntime.di

import dev.carrion.koinruntime.domain.GetGreetingUseCase
import dev.carrion.koinruntime.domain.GreetingRepository

fun provideGetGreetingUseCase(greetingRepository: GreetingRepository) =
    GetGreetingUseCase(greetingRepository)
