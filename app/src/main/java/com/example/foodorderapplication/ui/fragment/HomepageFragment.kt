package com.example.foodorderapplication.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView.OnQueryTextListener
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import com.example.foodorderapplication.R
import com.example.foodorderapplication.databinding.FragmentHomepageBinding
import com.example.foodorderapplication.ui.adapter.FoodsAdapter
import com.example.foodorderapplication.ui.viewmodel.HomepageViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomepageFragment : Fragment() {
    private lateinit var binding: FragmentHomepageBinding
    private lateinit var viewModel: HomepageViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomepageBinding.inflate(inflater, container, false)

        viewModel.foodsList.observe(viewLifecycleOwner){
            val foodsAdapter = FoodsAdapter(requireContext(),it)
            binding.foodsRv.adapter = foodsAdapter
        }

        binding.foodsRv.layoutManager = GridLayoutManager(context, 2)


        binding.imageViewCart.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.actionCart)
        }
        binding.searchView.setOnQueryTextListener(object : OnQueryTextListener{
            override fun onQueryTextSubmit(query: String): Boolean {
                viewModel.search(query)
                return true
            }

            override fun onQueryTextChange(newText: String): Boolean {
                viewModel.search(newText)
                return true
            }

        })
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: HomepageViewModel by viewModels()
        viewModel = tempViewModel
    }

    override fun onResume() {
        super.onResume()
        viewModel.foodsLoad()
    }
}