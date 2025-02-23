package dev.carrion.koinruntime.di

import dev.carrion.koinruntime.data.DefaultGreetingRepository
import dev.carrion.koinruntime.data.GreetingDataSource
import dev.carrion.koinruntime.data.local.LocalGreetingDataSource
import dev.carrion.koinruntime.data.local.provideLocalGreet
import dev.carrion.koinruntime.domain.GreetingRepository
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single

@Module
class DataModule {
    @Single
    fun provideLocalGreetingProvider(): () -> String = ::provideLocalGreet

    @Single
    fun provideGreetingDataSource(localGreetingProvider: () -> String): GreetingDataSource =
        LocalGreetingDataSource(localGreetingProvider)

    @Single
    fun provideGreetingRepository(greetingDataSource: GreetingDataSource): GreetingRepository =
        DefaultGreetingRepository(greetingDataSource)
}
