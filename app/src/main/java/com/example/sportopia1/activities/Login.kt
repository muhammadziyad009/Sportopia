package com.example.sportopia1.activities

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.sportopia1.R
import com.example.sportopia1.databinding.ActivityLandingBinding
import com.example.sportopia1.databinding.ActivityLoginBinding

class Login : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //customized to action bar arrow and info
        supportActionBar?.setBackgroundDrawable(ColorDrawable(Color.WHITE))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title= "Login to your Account"
        supportActionBar?.elevation=0F









            binding.btnLogin.setOnClickListener {
                val email=binding.etEmail.text
                val password=binding.etPassword.text

                if (TextUtils.isEmpty(email))
                {
                    binding.etEmail.error="Enter your Email"
                    binding.etEmail.requestFocus()
                }
                else if (TextUtils.isEmpty(password))
                {
                    binding.etPassword.error="Enter your Password"
                    binding.etPassword.requestFocus()
                }
                else{
                    val intent=Intent(this,Profile::class.java)
                    startActivity(intent)
                    Toast.makeText(this,"Welcome ",LENGTH_SHORT).show()
                }


//intent wala code signup page pr jany k liye
                binding.tvSignup.setOnClickListener {
                    val i= Intent(this,SignUp::class.java)
                    startActivity(i)



            }
}
}
}