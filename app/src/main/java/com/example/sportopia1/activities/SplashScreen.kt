package com.example.sportopia1.activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.sportopia1.adapters.SharedPreManager
import com.example.sportopia1.databinding.ActivitySplashScreenBinding

class SplashScreen : AppCompatActivity() {
    private lateinit var binding: ActivitySplashScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)


        supportActionBar?.hide()

       Handler(Looper.myLooper()!!).postDelayed(

           {
               val sharedPreManager=SharedPreManager(this)
               if (sharedPreManager.isFirstTime) {

                       val i = Intent(this, OnBoardingScreen::class.java)
                       startActivity(i)
                       finish()
                   }

               else

                   {
                       val i= Intent(this,Login::class.java)
                       startActivity(i)
                       finish()
                   }






       },3000)
    }
}