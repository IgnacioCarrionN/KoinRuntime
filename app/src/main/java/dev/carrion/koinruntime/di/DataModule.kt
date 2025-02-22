package dev.carrion.koinruntime.di

import dev.carrion.koinruntime.data.DefaultGreetingRepository
import dev.carrion.koinruntime.data.GreetingDataSource
import dev.carrion.koinruntime.data.local.LocalGreetingDataSource
import dev.carrion.koinruntime.data.local.provideLocalGreet
import dev.carrion.koinruntime.domain.GreetingRepository

fun provideLocalGreetingProvider(): () -> String = ::provideLocalGreet

fun provideGreetingDataSource(localGreetingProvider: () -> String): GreetingDataSource =
    LocalGreetingDataSource(localGreetingProvider)

fun provideGreetingRepository(greetingDataSource: GreetingDataSource): GreetingRepository =
    DefaultGreetingRepository(greetingDataSource)
