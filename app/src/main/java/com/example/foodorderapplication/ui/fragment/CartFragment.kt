package com.example.foodorderapplication.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodorderapplication.R
import com.example.foodorderapplication.databinding.FragmentCartBinding
import com.example.foodorderapplication.ui.adapter.CartFoodsAdapter
import com.example.foodorderapplication.ui.viewmodel.CartViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CartFragment : Fragment() {
    private lateinit var binding: FragmentCartBinding
    private lateinit var viewModel: CartViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCartBinding.inflate(inflater, container, false)

        viewModel.cartFoodsList.observe(viewLifecycleOwner){
            val cartFoodsAdapter = CartFoodsAdapter(requireContext(),it,viewModel)
            binding.cartFoodsRv.adapter = cartFoodsAdapter
        }
        viewModel.subTotalOrderPrice.observe(viewLifecycleOwner) {
            var totalPrice = 0
            if (it > 0){
                binding.textViewDeliveryCharge.text = "₺50"
                totalPrice = it + 50
            }
            else{
                binding.textViewDeliveryCharge.text = "₺0"
                totalPrice = it
            }
            binding.textViewSubTotalPrice.text = "₺"+it.toString()
            binding.textViewTotalPrice.text = "₺"+totalPrice.toString()
        }

        binding.cartFoodsRv.layoutManager = LinearLayoutManager(requireContext())

        binding.imageViewReturnHomePage.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.actionCartToHomepage)
        }
        binding.buttonCartApply.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.actionCartToOrder)
            viewModel.removeAllCartFoods("Meric")
        }
        return binding.root
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: CartViewModel by viewModels()
        viewModel = tempViewModel
    }
}