package com.example.foodorderapplication.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.foodorderapplication.data.repo.CartFoodsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FoodDetailViewModel @Inject constructor(var cfrepo: CartFoodsRepository): ViewModel(){
    fun addCart(food_name: String,
                food_image_name: String,
                food_price: Int,
                food_order_amount: Int,
                nickname: String){
        CoroutineScope(Dispatchers.Main).launch {
            cfrepo.addCart(food_name, food_image_name, food_price,food_order_amount,nickname)
        }
    }
}