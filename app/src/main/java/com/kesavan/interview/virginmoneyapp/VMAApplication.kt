package com.kesavan.interview.virginmoneyapp

import android.app.Application
import com.kesavan.interview.virginmoneyapp.di.AppModule
import com.kesavan.interview.virginmoneyapp.di.NetworkModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class VMAApplication:Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@VMAApplication)
            modules(listOf(AppModule, NetworkModule))
        }

    }
}