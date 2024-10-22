package com.projectx.homework1_5month.app

import android.app.Application
import org.koin.core.context.startKoin
import org.koin.android.ext.koin.androidContext
import com.projectx.homework1_5month.network.repositoryModule
import com.projectx.homework1_5month.viewModel.viewModelModule
import networkModule

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(listOf(networkModule, repositoryModule, viewModelModule))
        }
    }
}
