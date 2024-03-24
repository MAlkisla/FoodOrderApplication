package com.example.foodorderapplication.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.foodorderapplication.databinding.FragmentFoodDetailBinding
import com.example.foodorderapplication.ui.viewmodel.FoodDetailViewModel

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

        binding.imageViewFoodImage.setImageResource(
            requireContext().resources.getIdentifier(
                inboundFood.food_image_name, "drawable", requireContext().packageName
            )
        )

        binding.textViewFoodPrice.text = inboundFood.food_price.toString()

        binding.textViewAmount.text = "1"
        binding.textViewTotalPrice.text = "${1 * inboundFood.food_price}"

        binding.buttonAddCart.setOnClickListener {
            val amountString = binding.textViewAmount.text.toString()
            val amount = amountString.toIntOrNull() ?: 1
            viewModel.addCart(inboundFood.food_name, inboundFood.food_image_name,
                inboundFood.food_price,amount,"Meric")
        }
        binding.imageViewIncrease.setOnClickListener {
            val amountString = binding.textViewAmount.text.toString()
            val currentAmount = amountString.toIntOrNull() ?: 1
            val newAmount = currentAmount + 1
            binding.textViewAmount.text = newAmount.toString()
            viewModel.update(inboundFood.food_id,newAmount)
            binding.textViewTotalPrice.text = "${newAmount * inboundFood.food_price}"
        }

        binding.imageViewReduce.setOnClickListener {
            val amountString = binding.textViewAmount.text.toString()
            val currentAmount = amountString.toIntOrNull() ?: 1
            var newAmount = currentAmount - 1
            binding.textViewAmount.text = newAmount.toString()
            if (newAmount <= 0) {
                binding.textViewAmount.text = "1"
                viewModel.update(inboundFood.food_id,1)
                binding.textViewTotalPrice.text = "${1 * inboundFood.food_price}"
            }
            else {
                viewModel.update(inboundFood.food_id,newAmount)
                binding.textViewTotalPrice.text = "${newAmount * inboundFood.food_price}"
            }
        }

        return binding.root
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: FoodDetailViewModel by viewModels()
        viewModel = tempViewModel
    }
}