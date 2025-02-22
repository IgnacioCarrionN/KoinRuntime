package dev.carrion.koinruntime.di

import dev.carrion.koinruntime.domain.GetGreetingUseCase
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val domainModule = module {
    factoryOf(::GetGreetingUseCase)
}
