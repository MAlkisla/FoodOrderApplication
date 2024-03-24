package com.example.foodorderapplication.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.foodorderapplication.data.repo.CartFoodsRepository
import com.example.foodorderapplication.data.repo.FoodsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CartViewModel @Inject constructor(var frepo: FoodsRepository, var cfrepo: CartFoodsRepository):ViewModel(){
    fun remove(cart_food_id:Int){
        CoroutineScope(Dispatchers.Main).launch {
            cfrepo.remove(cart_food_id)
            frepo.foodsLoad()
        }
    }
}