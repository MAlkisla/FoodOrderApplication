package com.example.foodorderapplication.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.foodorderapplication.data.entity.Foods
import com.example.foodorderapplication.data.repo.FoodsRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomepageViewModel: ViewModel() {
    var frepo = FoodsRepository()
    var foodsList= MutableLiveData<List<Foods>>()

    init {
        foodsLoad()
    }
    fun foodsLoad(){
        CoroutineScope(Dispatchers.Main).launch {
            foodsList.value = frepo.foodsLoad()
        }
    }

    fun search(searchWord: String) {
        CoroutineScope(Dispatchers.Main).launch{
            foodsList.value = frepo.search(searchWord)
        }
    }
}