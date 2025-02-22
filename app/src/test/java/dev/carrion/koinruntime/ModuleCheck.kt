package dev.carrion.koinruntime

import dev.carrion.koinruntime.di.appModule
import org.junit.Test
import org.koin.core.annotation.KoinExperimentalAPI
import org.koin.test.verify.verify

class ModuleCheck {

    @OptIn(KoinExperimentalAPI::class)
    @Test
    fun `Check Koin configuration`() {
        appModule.verify()
    }
}