package com.example.foodorderapplication.data.repo

import com.example.foodorderapplication.data.datasource.CartFoodsDataSource
import com.example.foodorderapplication.data.datasource.FoodsDataSource

class CartFoodsRepository(var cfds: CartFoodsDataSource) {

    suspend fun carFoodsLoad(nickname: String) = cfds.cartFoodsLoad(nickname)
    suspend fun addCart(food_name: String,
                        food_image_name: String,
                        food_price: Int,
                        food_order_amount: Int,
                        nickname: String) = cfds.addCart( food_name, food_image_name, food_price,food_order_amount,nickname)

    /*suspend fun update(cart_food_id:Int,
                       food_order_amount: Int) = cfds.update(cart_food_id, food_order_amount)
*/
    suspend fun remove(cart_food_id: Int,nickname: String) = cfds.remove(cart_food_id,nickname)
}