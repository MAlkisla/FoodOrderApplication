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