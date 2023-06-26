package com.example.restaurant_test.data.dataSource

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@TypeConverters(value = [MyConverterTypes::class])
@Database(entities = [CartEntity::class], version = 2, exportSchema = true)
abstract class AppDatabase : RoomDatabase() {
    abstract val cartDao : CartDao
}