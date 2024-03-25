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
                nickname: String) {
        CoroutineScope(Dispatchers.Main).launch {
            try {
                val cartFoods = cfrepo.cartFoodsLoad(nickname)
                val existingItem = cartFoods?.find { it.food_name == food_name }
                if (existingItem != null) {
                    existingItem.food_order_amount += food_order_amount
                    cfrepo.remove(existingItem.cart_food_id,nickname)
                    cfrepo.addCart(
                        existingItem.food_name, existingItem.food_image_name,
                        existingItem.food_price, existingItem.food_order_amount, nickname
                    )
                } else {
                    cfrepo.addCart(food_name, food_image_name, food_price, food_order_amount, nickname)
                }
            } catch (e: Exception) {
                cfrepo.addCart(food_name, food_image_name, food_price, food_order_amount, nickname)
            }
        }
    }
}