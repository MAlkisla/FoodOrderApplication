package com.example.foodorderapplication.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.foodorderapplication.data.entity.Foods
import com.example.foodorderapplication.data.repo.FoodsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel

class HomepageViewModel @Inject constructor(var frepo: FoodsRepository): ViewModel() {
    var originalFoodsList = MutableLiveData<List<Foods>>()
    var foodsList = MutableLiveData<List<Foods>>()

    init {
        foodsLoad()
    }
    fun foodsLoad(){
        CoroutineScope(Dispatchers.Main).launch {
            originalFoodsList.value = frepo.foodsLoad()
            foodsList.value = originalFoodsList.value
        }
    }

    fun search(query: String) {
        CoroutineScope(Dispatchers.Main).launch {
            val filteredList = originalFoodsList.value?.filter { food ->
                food.food_name.contains(query, ignoreCase = true)
            }
            foodsList.value = filteredList!!
        }
    }
}