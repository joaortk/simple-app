package com.test.simpleapp.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.test.simpleapp.common.ViewModelFactory
import com.test.simpleapp.common.ViewModelKey
import com.test.simpleapp.feature.shortener.ShortenerViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(ShortenerViewModel::class)
    internal abstract fun bindShortenerViewModel(viewModel: ShortenerViewModel): ViewModel
}