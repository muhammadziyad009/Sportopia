package com.example.sportopia1.activities

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.sportopia1.R
import com.example.sportopia1.databinding.ActivityLandingBinding
import com.example.sportopia1.fragments.CartFragment
import com.example.sportopia1.fragments.HomeFragment
import com.example.sportopia1.fragments.SearchFragment

class Landing : AppCompatActivity() {
    private lateinit var binding:ActivityLandingBinding
    private lateinit var fragmentManager: FragmentManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding=ActivityLandingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()




        binding.bottomNavigation.background = null

        binding.bottomNavigation.setOnItemSelectedListener {
                item -> when(item.itemId){
            R.id.home_bottom_nav -> openFragment(HomeFragment())
            R.id.cart_bottom_nav -> openFragment(CartFragment())
            R.id.search_bottom_nav -> openFragment(SearchFragment())
        }
            true
        }

        fragmentManager = supportFragmentManager
        openFragment(HomeFragment())



    }
    private fun openFragment(fragment: Fragment){
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container, fragment)
        fragmentTransaction.commit()
    }
}