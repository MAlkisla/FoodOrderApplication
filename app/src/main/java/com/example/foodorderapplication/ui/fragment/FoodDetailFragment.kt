package com.example.foodorderapplication.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.foodorderapplication.R
import com.example.foodorderapplication.data.entity.Foods
import com.example.foodorderapplication.databinding.ActivityMainBinding
import com.example.foodorderapplication.databinding.FragmentFoodDetailBinding
import com.example.foodorderapplication.ui.viewmodel.CartViewModel
import com.example.foodorderapplication.ui.viewmodel.FoodDetailViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlin.random.Random

@AndroidEntryPoint
class FoodDetailFragment : Fragment() {
    private lateinit var binding: FragmentFoodDetailBinding
    private lateinit var viewModel: FoodDetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFoodDetailBinding.inflate(inflater, container, false)

        val bundle: FoodDetailFragmentArgs by navArgs()
        val inboundFood = bundle.food

        binding.textViewFoodName.text = inboundFood.food_name

        showImage(inboundFood)

        binding.textViewFoodPrice.text = "₺"+inboundFood.food_price.toString() + ".00"

        binding.textViewAmount.text = "1"
        binding.textViewTotalPrice.text = "₺${1 * inboundFood.food_price}.00"

        binding.buttonAddCart.setOnClickListener {
            val amountString = binding.textViewAmount.text.toString()
            val amount = amountString.toIntOrNull() ?: 1
            viewModel.addCart(
            inboundFood.food_name, inboundFood.food_image_name,
                inboundFood.food_price, amount, "Meric"
            )
        }
        binding.imageViewIncrease.setOnClickListener {
            val amountString = binding.textViewAmount.text.toString()
            val currentAmount = amountString.toIntOrNull() ?: 1
            val newAmount = currentAmount + 1
            binding.textViewAmount.text = newAmount.toString()
            binding.textViewTotalPrice.text = "₺${newAmount * inboundFood.food_price}.00"

        }

        binding.imageViewReduce.setOnClickListener {
            val amountString = binding.textViewAmount.text.toString()
            val currentAmount = amountString.toIntOrNull() ?: 1
            var newAmount = currentAmount - 1
            binding.textViewAmount.text = newAmount.toString()
            if (newAmount <= 0) {
                binding.textViewAmount.text = "1"
                binding.textViewTotalPrice.text = "₺${1 * inboundFood.food_price}.00"
            } else {
                binding.textViewTotalPrice.text = "₺${newAmount * inboundFood.food_price}.00"
            }
        }

        binding.ratingBar2.rating = Random.nextInt(2, 5).toFloat()
        binding.buttonReturnHomepage.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.actionDetailToHomepage)
        }
        return binding.root
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: FoodDetailViewModel by viewModels()
        viewModel = tempViewModel
    }

    fun showImage(food: Foods) {
        val url = "http://kasimadalan.pe.hu/yemekler/resimler/${food.food_image_name}"
        Glide.with(this).load(url).override(500, 500).into(binding.imageViewFoodImage)
    }
}