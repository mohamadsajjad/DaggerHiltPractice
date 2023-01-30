package com.example.daggerhiltpractice.di

import android.app.Application
import androidx.room.Room
import com.example.daggerhiltpractice.model.local.AppDatabase
import com.example.daggerhiltpractice.model.local.repository.DatabaseRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DBModule {

    @Singleton
    @Provides
    fun provideDatabase(appContext:Application): AppDatabase {
        return Room.databaseBuilder(
            appContext,
            AppDatabase::class.java,
            "character_database"
        ).build()
    }

    @Singleton
    @Provides
    fun provideDatabaseRepository(appDatabase: AppDatabase):DatabaseRepository{
        return DatabaseRepository(appDatabase.characterDao())
    }

}