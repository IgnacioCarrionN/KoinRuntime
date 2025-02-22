package dev.carrion.koinruntime.domain

interface GreetingRepository {
    suspend fun getGreeting(): Result<String>
}
