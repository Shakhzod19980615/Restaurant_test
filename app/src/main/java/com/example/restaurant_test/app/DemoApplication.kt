package com.example.restaurant_test.app

import android.app.Application
import com.example.restaurant_test.di.AppComponent

class DemoApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        AppComponent.create(this)
    }
}