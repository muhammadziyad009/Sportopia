package com.example.sportopia1.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sportopia1.R
import com.example.sportopia1.activities.PaymentActivity
import com.example.sportopia1.adapters.CartAdapter
import com.example.sportopia1.databinding.FragmentCartBinding

class CartFragment : Fragment() {
    private lateinit var binding: FragmentCartBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCartBinding.inflate(inflater, container, false)
        val cartProductName = listOf("Basketball", "Volleyball", "Cricket Bat", "Racket", "Hard Ball", "Football")
        val cartProductPrice = listOf("$5", "$6", "$8", "$10", "$19", "$30")
        val cartImage = listOf(
            R.drawable.basket_ball,
            R.drawable.volley_ball,
            R.drawable.cricket_bat,
            R.drawable.racket,
            R.drawable.hard_ball,
            R.drawable.foot_ball,
        )

        val adapter = CartAdapter(ArrayList(cartProductName), ArrayList(cartProductPrice), ArrayList(cartImage))
        binding.cardRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.cardRecyclerView.adapter = adapter
        binding.proccedButton.setOnClickListener {
            val intent = Intent(requireContext(), PaymentActivity::class.java)
            startActivity(intent)
        }

        return binding.root
    }
}
