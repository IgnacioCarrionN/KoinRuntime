package dev.carrion.koinruntime.data

import dev.carrion.koinruntime.domain.GreetingRepository

class DefaultGreetingRepository(
    private val greetingDataSource: GreetingDataSource
) : GreetingRepository {
    override suspend fun getGreeting(): Result<String> = greetingDataSource.getGreeting()
}
