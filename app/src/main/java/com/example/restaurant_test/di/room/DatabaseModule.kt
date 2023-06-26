package com.example.restaurant_test.di.room

import android.app.Application
import androidx.room.Room
import com.example.restaurant_test.data.dataSource.AppDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(applicationContext: Application): AppDatabase {
        return Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "app_database.db"
        ).fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideCartDao(db:AppDatabase) = db.cartDao
}