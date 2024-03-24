package com.example.foodorderapplication.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.foodorderapplication.data.repo.CartFoodsRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FoodDetailViewModel : ViewModel(){
    var cfrepo= CartFoodsRepository()

    fun addCart(food_name: String,
                food_image_name: String,
                food_price: Int,
                food_order_amount: Int,
                nickname: String){
        CoroutineScope(Dispatchers.Main).launch {
            cfrepo.addCart(food_name, food_image_name, food_price,food_order_amount,nickname)
        }
    }

    fun update(cart_food_id:Int,
               food_order_amount: Int){
        CoroutineScope(Dispatchers.Main).launch {
            cfrepo.update(cart_food_id, food_order_amount)
        }
    }


}