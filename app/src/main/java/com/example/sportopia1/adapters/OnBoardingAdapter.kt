package com.example.sportopia.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.sportopia1.fragments.OnBoardingFragment1
import com.example.sportopia1.fragments.OnBoardingFragment2
import com.example.sportopia1.fragments.OnBoardingFragment3


class OnBoardingAdapter(fragmentManager: FragmentManager,lifecycle: Lifecycle):
    FragmentStateAdapter(fragmentManager,lifecycle) {
    override fun getItemCount(): Int {
        return 3

    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> OnBoardingFragment1()
            1 -> OnBoardingFragment2()
            else -> OnBoardingFragment3()
        }

    }

}