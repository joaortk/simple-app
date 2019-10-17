package com.test.simpleapp.di.modules

import com.test.simpleapp.data.api.AliasAPI
import com.test.simpleapp.domain.repository.impl.ShortenerRepositoryImpl
import com.test.simpleapp.domain.repository.ShortenerRepository
import dagger.Module
import dagger.Provides
import dagger.Reusable

@Module
class RepositoryModule {
    @Provides
    @Reusable
    fun provideShortenerRepository(aliasAPI: AliasAPI): ShortenerRepository =
        ShortenerRepositoryImpl(aliasAPI)
}