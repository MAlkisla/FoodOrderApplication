package com.example.foodorderapplication.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.foodorderapplication.data.repo.CartFoodsRepository
import com.example.foodorderapplication.data.repo.FoodsRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CartViewModel:ViewModel(){
    var cfrepo= CartFoodsRepository()
    var frepo = FoodsRepository()
    fun remove(cart_food_id:Int){
        CoroutineScope(Dispatchers.Main).launch {
            cfrepo.remove(cart_food_id)
            frepo.foodsLoad()
        }
    }
}