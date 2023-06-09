package com.example.restaurant_test.ui.fragment

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.restaurant_test.R
import com.example.restaurant_test.di.AppComponent
import javax.inject.Inject

class ProfileFragment:Fragment(R.layout.fragment_profile) {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    override fun onAttach(context: Context) {
        super.onAttach(context)
        AppComponent.get().inject(this)

    }
}