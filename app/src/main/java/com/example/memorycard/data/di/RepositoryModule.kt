package com.example.memorycard.data.di

import com.example.memorycard.data.database.DaoDatabase
import com.example.memorycard.data.repository.Repository
import com.example.memorycard.data.repository.RepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideRepository(dao: DaoDatabase): Repository{
        return RepositoryImpl(dao)
    }
}