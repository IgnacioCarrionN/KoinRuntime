package dev.carrion.koinruntime.di

import org.koin.core.annotation.Module

@Module(includes = [DomainModule::class, DataModule::class, PresentationModule::class])
class AppModule