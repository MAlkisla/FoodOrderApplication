package com.example.foodorderapplication.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.foodorderapplication.R
import com.example.foodorderapplication.databinding.FragmentOrderBinding
import com.example.foodorderapplication.ui.viewmodel.HomepageViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OrderFragment : Fragment() {
    private lateinit var binding : FragmentOrderBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOrderBinding.inflate(inflater, container, false)
        binding.buttonReturnHomepage.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.actionOrderToHomepage)
        }
        return binding.root
    }
}