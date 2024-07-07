package com.example.sportopia1.activities
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.sportopia.adapters.OnBoardingAdapter
import com.example.sportopia1.adapters.SharedPreManager
import com.example.sportopia1.databinding.ActivityOnBoardingScreenBinding


class OnBoardingScreen : AppCompatActivity() {
    private lateinit var binding: ActivityOnBoardingScreenBinding
    private lateinit var adapter: OnBoardingAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityOnBoardingScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)



        supportActionBar?.hide()
        adapter = OnBoardingAdapter(supportFragmentManager,lifecycle)

        binding.onboardingViewPager.adapter=adapter
        val viewPager=binding.onboardingViewPager

       binding.fbtnNext.setOnClickListener {

            viewPager.setCurrentItem(viewPager.currentItem +1,true)
            if(viewPager.currentItem==2)
            {
                endOnboardingScreens()
            }


        }


    }

    //function that move to home page and also update value of session in shared preference
    private fun endOnboardingScreens()
    {

        val sharedPreferenceManger = SharedPreManager(this)
        sharedPreferenceManger.isFirstTime = false

        val i = Intent(this, Login:: class.java)
        startActivity(i)
        finish()
    }






    }