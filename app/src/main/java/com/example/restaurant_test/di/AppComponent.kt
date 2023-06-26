package com.example.restaurant_test.di

import android.app.Application
import com.example.restaurant_test.di.networkmodule.NetworkModule
import com.example.restaurant_test.di.room.DatabaseModule
import com.example.restaurant_test.di.viewmodel.ViewModelModule
import com.example.restaurant_test.ui.fragment.*
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [DatabaseModule::class, NetworkModule::class,ViewModelModule::class])
interface AppComponent {
    fun inject(fragment: HomeFragment)
    fun inject(fragment: CartFragment)
    fun inject(fragment: SearchFragment)
    fun inject(fragment: ProfileFragment)
    fun inject(fragment: MenuFragment)
    fun inject(fragment:AllMenuFragment)
    fun inject(fragment:SaladMenuFragment)
    fun inject(fragment:WithFishMenuFragment)
    fun inject(fragment:WithRiceMenuFragment)
    fun inject(fragment:ItemDialogFragment)
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