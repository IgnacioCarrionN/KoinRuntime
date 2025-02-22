package dev.carrion.koinruntime.domain

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetGreetingUseCase(
    private val repository: GreetingRepository
) {
    suspend operator fun invoke(): Result<String> {
        return withContext(Dispatchers.IO) {
            repository.getGreeting()
        }
    }
}
