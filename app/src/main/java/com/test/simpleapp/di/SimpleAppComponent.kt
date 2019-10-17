package com.test.simpleapp.di

import com.test.simpleapp.di.modules.ApiModule
import com.test.simpleapp.di.modules.NetworkModule
import com.test.simpleapp.di.modules.RepositoryModule
import com.test.simpleapp.di.modules.ViewModelModule
import com.test.simpleapp.feature.shortener.ShortenerActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        NetworkModule::class,
        ApiModule::class,
        RepositoryModule::class,
        ViewModelModule::class
    ]
)
interface SimpleAppComponent {
    fun inject(shortenerActivity: ShortenerActivity)
}