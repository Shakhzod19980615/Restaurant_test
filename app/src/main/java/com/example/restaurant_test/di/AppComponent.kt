package com.example.restaurant_test.di

import android.app.Application
import androidx.core.view.KeyEventDispatcher
import com.example.restaurant_test.di.networkmodule.NetworkModule
import com.example.restaurant_test.di.viewmodel.ViewModelModule
import com.example.restaurant_test.ui.CartFragment
import com.example.restaurant_test.ui.HomeFragment
import com.example.restaurant_test.ui.ProfileFragment
import com.example.restaurant_test.ui.SearchFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class,ViewModelModule::class])
interface AppComponent {
    fun inject(fragment: HomeFragment)
    fun inject(fragment: CartFragment)
    fun inject(fragment: SearchFragment)
    fun inject(fragment: ProfileFragment)
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: Application): AppComponent
    }

    companion object {
        private var instance: AppComponent? = null
        lateinit var application: Application

        fun create(application: Application):AppComponent{
            instance = DaggerAppComponent.factory().create(application)
            return instance!!
        }

        fun get(): AppComponent {
            return requireNotNull(instance) {"AppComponent  must be initialized"}
        }

    }


}