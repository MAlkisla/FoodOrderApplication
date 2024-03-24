package com.example.foodorderapplication.data.datasource

import android.util.Log

class CartFoodsDataSource {
    suspend fun addCart(food_name: String,
                        food_image_name: String,
                        food_price: Int,
                        food_order_amount: Int,
                        nickname: String) {
        Log.e("Yemek Ekle", "${food_order_amount} x ${food_name} - ${food_image_name} - ${food_price} - ${nickname}")
    }

    suspend fun update(cart_food_id:Int,
                       food_order_amount: Int){
        Log.e("Yemek Güncelle", "${food_order_amount} x ${cart_food_id} Nolu Yemek")
    }

    fun remove(cart_food_id:Int){
        Log.e("Yemeği Sepetten Sil", cart_food_id.toString())
    }
}