package com.datn.studytextscan

import android.app.Application
import com.datn.studytextscan.di.appModule
import com.datn.studytextscan.di.repoModule
import com.datn.studytextscan.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApp)
            modules(listOf(appModule, repoModule, viewModelModule))
        }
    }
}