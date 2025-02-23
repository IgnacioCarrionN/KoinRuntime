package dev.carrion.koinruntime.di

import dev.carrion.koinruntime.domain.GetGreetingUseCase
import dev.carrion.koinruntime.domain.GreetingRepository
import org.koin.core.annotation.Factory
import org.koin.core.annotation.Module

@Module
class DomainModule {

    @Factory
    fun provideGetGreetingUseCase(greetingRepository: GreetingRepository) =
        GetGreetingUseCase(greetingRepository)
}
