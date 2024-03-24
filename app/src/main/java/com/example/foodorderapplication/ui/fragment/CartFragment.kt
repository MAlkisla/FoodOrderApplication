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
import com.example.foodorderapplication.ui.viewmodel.CartViewModel

class CartFragment : Fragment() {
    private lateinit var binding: FragmentCartBinding
    private lateinit var viewModel: CartViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCartBinding.inflate(inflater, container, false)

        val cartFoodsList = ArrayList<CartFoods>()
        val c1 = CartFoods(1,"Ayran","ayran",123,2,"Meric")
        cartFoodsList.add(c1)

        val cartFoodsAdapter = CartFoodsAdapter(requireContext(),cartFoodsList,viewModel)
        binding.cartFoodsRv.adapter = cartFoodsAdapter
        binding.cartFoodsRv.layoutManager = LinearLayoutManager(requireContext())
        return binding.root
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: CartViewModel by viewModels()
        viewModel = tempViewModel
    }
}