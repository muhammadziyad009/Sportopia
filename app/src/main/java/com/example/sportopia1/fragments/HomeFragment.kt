package com.example.sportopia1.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import com.example.sportopia1.R
import com.example.sportopia1.databinding.FragmentHomeBinding



class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        binding.btnBuyBb.setOnClickListener{
            Toast.makeText(context,"Added to Cart", LENGTH_SHORT).show()
        }
        binding.btnBuyVb.setOnClickListener{
            Toast.makeText(context,"Added to Cart", LENGTH_SHORT).show()
        }
        binding.btnBuyRacket.setOnClickListener{
            Toast.makeText(context,"Added to Cart", LENGTH_SHORT).show()
        }
        binding.btnBuyCbat.setOnClickListener{
            Toast.makeText(context,"Added to Cart", LENGTH_SHORT).show()
        }
        binding.btnBuyFootball.setOnClickListener{
            Toast.makeText(context,"Added to Cart", LENGTH_SHORT).show()
        }
        binding.btnBuyCball.setOnClickListener{
            Toast.makeText(context,"Added to Cart", LENGTH_SHORT).show()
        }



        return binding.root


    }




    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Load images and set up ImageSlider
        val imgList = ArrayList<SlideModel>()
        imgList.add(SlideModel(R.drawable.banner1, "Sports Collection"))
        imgList.add(SlideModel(R.drawable.banner2, "Off on Selected items"))
        imgList.add(SlideModel(R.drawable.banner3, "Sports Equipment"))
        imgList.add(SlideModel(R.drawable.banner4, "Sale upto 40% off"))

        binding.imageSlider.setImageList(imgList, ScaleTypes.FIT)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }




}
