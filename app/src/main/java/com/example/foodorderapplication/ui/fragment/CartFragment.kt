package com.example.foodorderapplication.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodorderapplication.data.entity.CartFoods
import com.example.foodorderapplication.databinding.FragmentCartBinding
import com.example.foodorderapplication.ui.adapter.CartFoodsAdapter
import com.example.foodorderapplication.ui.adapter.FoodsAdapter
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

        viewModel.totalOrderPrice.observe(viewLifecycleOwner) {
            binding.textViewOrderTotalPrice.text = it.toString()
        }

        binding.cartFoodsRv.layoutManager = LinearLayoutManager(requireContext())
        return binding.root
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: CartViewModel by viewModels()
        viewModel = tempViewModel
    }
}