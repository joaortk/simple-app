package com.test.simpleapp.di

import com.test.simpleapp.di.modules.*
import com.test.simpleapp.feature.shortener.ShortenerActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        NetworkModule::class,
        ApiModule::class,
        CommonModule::class,
        RepositoryModule::class,
        ViewModelModule::class
    ]
)
interface SimpleAppComponent {
    fun inject(shortenerActivity: ShortenerActivity)
}