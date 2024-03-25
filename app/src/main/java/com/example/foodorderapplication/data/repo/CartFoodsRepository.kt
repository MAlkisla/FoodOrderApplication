package com.example.foodorderapplication.data.repo

import com.example.foodorderapplication.data.datasource.CartFoodsDataSource

class CartFoodsRepository(var cfds: CartFoodsDataSource) {

    suspend fun cartFoodsLoad(nickname: String) = cfds.cartFoodsLoad(nickname)
    suspend fun addCart(food_name: String,
                        food_image_name: String,
                        food_price: Int,
                        food_order_amount: Int,
                        nickname: String) = cfds.addCart( food_name, food_image_name, food_price,food_order_amount,nickname)

    suspend fun remove(cart_food_id: Int,nickname: String) = cfds.remove(cart_food_id,nickname)

}