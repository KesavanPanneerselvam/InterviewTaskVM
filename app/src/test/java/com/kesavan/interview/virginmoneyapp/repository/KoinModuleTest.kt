package com.kesavan.interview.virginmoneyapp.repository

import com.kesavan.interview.virginmoneyapp.di.AppModule
import com.kesavan.interview.virginmoneyapp.di.NetworkModule
import org.junit.Test
import org.koin.core.logger.Level
import org.koin.dsl.koinApplication
import org.koin.test.KoinTest
import org.koin.test.check.checkModules

class KoinModuleTest : KoinTest {

    @Test
    fun testCoreModule() {
        koinApplication {
            printLogger(Level.DEBUG)
            modules(listOf(AppModule, NetworkModule))
        }.checkModules()
    }

}