package com.test.simpleapp

import android.app.Application
import com.test.simpleapp.di.DaggerSimpleAppComponent
import com.test.simpleapp.di.SimpleAppComponent
import com.test.simpleapp.di.modules.ApiModule
import com.test.simpleapp.di.modules.NetworkModule
import com.test.simpleapp.di.modules.RepositoryModule

class SimpleApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerSimpleAppComponent
            .builder()
            .apiModule(ApiModule())
            .networkModule(NetworkModule(getString(R.string.base_url)))
            .repositoryModule(RepositoryModule())
            .build()
    }

    companion object {
        lateinit var appComponent: SimpleAppComponent
    }
}