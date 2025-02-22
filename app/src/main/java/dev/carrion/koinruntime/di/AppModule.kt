package dev.carrion.koinruntime.di

import org.koin.dsl.module

val appModule = module {
    includes(
        domainModule,
        dataModule,
        presentationModule
    )
}
