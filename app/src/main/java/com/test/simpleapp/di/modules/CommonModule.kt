package com.test.simpleapp.di.modules

import com.test.simpleapp.common.ValidationUtils
import com.test.simpleapp.common.ValidationUtilsImpl
import dagger.Module
import dagger.Provides

@Module
class CommonModule {
    @Provides
    fun provideValidationUtils(): ValidationUtils = ValidationUtilsImpl()
}