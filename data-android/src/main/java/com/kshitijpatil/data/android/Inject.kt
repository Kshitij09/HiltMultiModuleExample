package com.kshitijpatil.data.android

import com.kshitijpatil.api.ApiModule
import com.kshitijpatil.api.MockApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
object RepositoryModule {

    @Singleton
    @Provides
    fun provideMainRepository(api: MockApi): MainRepository {
        return MainRepository(api)
    }
}
