package com.test.simpleapp.di.modules

import com.test.simpleapp.data.api.AliasAPI
import dagger.Module
import dagger.Provides
import dagger.Reusable
import retrofit2.Retrofit

@Module
class ApiModule {
    @Provides
    @Reusable
    fun provideAliasApi(retrofit: Retrofit): AliasAPI = retrofit.create(AliasAPI::class.java)
}