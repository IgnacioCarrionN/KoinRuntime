package dev.carrion.koinruntime.data

interface GreetingDataSource {
    suspend fun getGreeting(): Result<String>
}
