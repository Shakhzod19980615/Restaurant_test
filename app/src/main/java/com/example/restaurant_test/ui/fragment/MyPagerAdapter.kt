package com.example.restaurant_test.ui.fragment

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter


class FragmentPageAdapter(
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle,
):FragmentStateAdapter(fragmentManager, lifecycle){
    override fun getItemCount(): Int {
        return 4
    }

    override fun createFragment(position: Int): Fragment {
        return if (position ==0){
            AllMenuFragment()
        }else if(position == 1){
            SaladMenuFragment()
        }else if(position ==2){
            WithRiceMenuFragment()
        }else{
            WithFishMenuFragment()
        }
    }


}