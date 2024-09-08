package com.example.memorycard.data.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.memorycard.data.database.CardDatabase
import com.example.memorycard.data.database.DaoDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): CardDatabase{
        return Room.databaseBuilder(
            context,
            CardDatabase::class.java,
            "card_db"
        ).build()
    }

    @Provides
    fun provideDao(database: CardDatabase): DaoDatabase{
        return database.getDao()
    }

}