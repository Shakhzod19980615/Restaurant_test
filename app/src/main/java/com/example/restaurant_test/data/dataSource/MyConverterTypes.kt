package com.example.restaurant_test.data.dataSource

import androidx.room.TypeConverter
import com.google.gson.Gson
import java.util.*

class MyConverterTypes {

    @TypeConverter
    fun fromDateToLong(date: Date): Long {
        return date.time
    }
    @TypeConverter
    fun fromLongToDate(date: Long): Date {
        return Date(date)
    }
    @TypeConverter
    fun fromJsonToTags(json:String):TagsList{
        return  Gson().fromJson(json,TagsList::class.java)
    }
}