package com.example.foodorderapplication.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView.OnQueryTextListener
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.foodorderapplication.data.entity.Foods
import com.example.foodorderapplication.databinding.FragmentHomepageBinding
import com.example.foodorderapplication.ui.adapter.FoodsAdapter
import com.example.foodorderapplication.ui.viewmodel.HomepageViewModel

class HomepageFragment : Fragment() {
    private lateinit var binding: FragmentHomepageBinding
    private lateinit var viewModel: HomepageViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomepageBinding.inflate(inflater, container, false)

        val foodsList = ArrayList<Foods>()
        val f1 = Foods(1,"Ayran","ayran",123)
        foodsList.add(f1)

        val foodsAdapter = FoodsAdapter(requireContext(),foodsList)
        binding.foodsRv.adapter = foodsAdapter
        binding.foodsRv.layoutManager = GridLayoutManager(context, 2)

        /*binding.buttonDetay.setOnClickListener {
            val amountString = binding.editTextYemekSayisi.text.toString()
            val amount = amountString.toIntOrNull() ?: 1

            val food = Foods(1, "Pizza", "noImage", 222)
            val action = HomepageFragmentDirections.actionDetail(food = food, amount = amount)

            Navigation.findNavController(it).navigate(action)
        }

        binding.buttonSepet.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.actionBasket)
        }*/

        binding.buttonSepeteEkle.setOnClickListener {
            val amountString = binding.editTextYemekSayisi.text.toString()
            val amount = amountString.toIntOrNull() ?: 1
            addBasket(amount, "Hamburger", "noImage", 1234)
        }

        binding.searchView.setOnQueryTextListener(object : OnQueryTextListener{
            override fun onQueryTextSubmit(query: String): Boolean {
                search(query)
                return true
            }

            override fun onQueryTextChange(newText: String): Boolean {
                search(newText)
                return true
            }

        })
        return binding.root
    }

    fun addBasket(amount: Int, food_name: String, food_image_name: String, food_price: Int) {
        Log.e("Sepete Ekle", "${amount} x ${food_name} - ${food_image_name} - ${food_price}")
    }

    fun search(searchWord: String) {
        Log.e("Yemek Ara",searchWord)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: HomepageViewModel by viewModels()
        viewModel = tempViewModel
    }
}