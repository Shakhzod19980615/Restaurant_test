package com.example.restaurant_test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.example.restaurant_test.databinding.ActivityMainBinding
import com.example.restaurant_test.ui.fragment.CartFragment
import com.example.restaurant_test.ui.fragment.HomeFragment
import com.example.restaurant_test.ui.fragment.ProfileFragment
import com.example.restaurant_test.ui.fragment.SearchFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (savedInstanceState == null) {
            replaceFragment(HomeFragment())
        }
        binding.bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.homeFragment -> replaceFragment(HomeFragment())
                R.id.searchFragment -> replaceFragment(SearchFragment())
                R.id.cartFragment -> replaceFragment(CartFragment())
                R.id.profileFragment -> replaceFragment(ProfileFragment())
                else -> Unit
            }
            true
        }
    }
    private fun replaceFragment(fragment: Fragment){
        supportFragmentManager.commit {
            replace(R.id.fragment_container_view_tag,fragment)
        }
    }

}