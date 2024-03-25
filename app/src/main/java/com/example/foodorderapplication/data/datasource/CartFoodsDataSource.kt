package com.example.foodorderapplication.data.datasource

import com.example.foodorderapplication.data.entity.CartFoods
import com.example.foodorderapplication.retrofit.FoodsDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CartFoodsDataSource(var fdao: FoodsDao) {
    suspend fun cartFoodsLoad(nickname: String) : List<CartFoods>? = withContext(Dispatchers.IO) {
        return@withContext fdao.cartFoodsLoad(nickname).cart
    }
    suspend fun addCart(food_name: String,
                        food_image_name: String,
                        food_price: Int,
                        food_order_amount: Int,
                        nickname: String) = fdao.addCart(food_name, food_image_name, food_price, food_order_amount, nickname)
    suspend fun remove(cart_food_id:Int,nickname: String ) = fdao.remove(cart_food_id, nickname)

}