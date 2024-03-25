package com.example.foodorderapplication.data.datasource

import android.util.Log
import com.example.foodorderapplication.retrofit.FoodsDao

class CartFoodsDataSource(var fdao: FoodsDao) {

    suspend fun addCart(food_name: String,
                        food_image_name: String,
                        food_price: Int,
                        food_order_amount: Int,
                        nickname: String) = fdao.addCart(food_name, food_image_name, food_price, food_order_amount, nickname)


    /*suspend fun update(cart_food_id:Int,
                       food_order_amount: Int)*/
    /*{
        Log.e("Yemek Güncelle", "${food_order_amount} x ${cart_food_id} Nolu Yemek")
    }*/

    suspend fun remove(cart_food_id:Int,nickname: String ) = fdao.remove(cart_food_id, nickname)
    /*{
        Log.e("Yemeği Sepetten Sil", cart_food_id.toString())
    }*/
}