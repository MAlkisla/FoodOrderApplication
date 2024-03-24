package com.example.foodorderapplication.data.entity

import java.io.Serializable

data class CartFoods(var cart_food_id: Int,
                     var food_name: String,
                     var food_image_name: String,
                     var food_price: Int,
                     var food_order_amount: Int,
                     var nickname: String) : Serializable {
}