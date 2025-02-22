package dev.carrion.koinruntime.di

import dev.carrion.koinruntime.data.DefaultGreetingRepository
import dev.carrion.koinruntime.data.GreetingDataSource
import dev.carrion.koinruntime.data.local.LocalGreetingDataSource
import dev.carrion.koinruntime.data.local.provideLocalGreet
import dev.carrion.koinruntime.domain.GreetingRepository
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val dataModule = module {
    single<() -> String> { ::provideLocalGreet }
    singleOf(::LocalGreetingDataSource) bind GreetingDataSource::class
    singleOf(::DefaultGreetingRepository) bind GreetingRepository::class
}
