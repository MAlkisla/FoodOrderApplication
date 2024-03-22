package com.example.foodorderapplication.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.foodorderapplication.R
import com.example.foodorderapplication.databinding.FragmentBasketBinding
import com.example.foodorderapplication.databinding.FragmentFoodDetailBinding

class FoodDetailFragment : Fragment() {
    private lateinit var binding: FragmentFoodDetailBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFoodDetailBinding.inflate(inflater, container, false)

        val bundle: FoodDetailFragmentArgs by navArgs()
        val inboundAmount = bundle.amount
        val inboundFood = bundle.food

        binding.textViewFoodDetail.text = "${inboundAmount} - ${inboundFood.food_name}"
        binding.textViewTotalPrice.text = "${inboundAmount * inboundFood.food_price}"

        binding.buttonUpdate.setOnClickListener {
            val amountString = binding.editTextYemekSayisi.text.toString()
            val amount = amountString.toIntOrNull() ?: 1

            update(amount,inboundFood.food_id,inboundFood.food_name,inboundFood.food_image_name,
                inboundFood.food_price)

            binding.textViewTotalPrice.text = "${amount * inboundFood.food_price}"
        }

        return binding.root
    }

    fun update(amount:Int, food_id:Int, food_name:String, food_image_name:String, food_price:Int){
        Log.e("Sepetteki Bu Yemeği Güncelle", "${amount} x ${food_name} - ${food_price * amount}")
    }
}