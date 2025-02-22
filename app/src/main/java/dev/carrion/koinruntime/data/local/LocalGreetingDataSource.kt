package dev.carrion.koinruntime.data.local

import dev.carrion.koinruntime.data.GreetingDataSource
import kotlinx.coroutines.delay
import kotlin.random.Random

class LocalGreetingDataSource(private val localGreetingProvider: () -> String) :
    GreetingDataSource {
    override suspend fun getGreeting(): Result<String> {
        return runCatching {
            delay(1000)
            val showError = Random.nextBoolean()
            if (showError) {
                throw Exception("Something went wrong")
            }
            localGreetingProvider()
        }
    }
}
