package com.kshitijpatil.data.android

import com.kshitijpatil.api.ApiModule
import com.kshitijpatil.api.MockApi
import com.kshitijpatil.api.NetworkModule
import com.kshitijpatil.api.users.UsersApi
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
    fun provideMainRepository(api: UsersApi): MainRepository {
        return MainRepository(api)
    }
}
