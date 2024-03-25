package com.example.foodorderapplication.data.entity

import com.google.gson.annotations.SerializedName

data class CartFoodsResponse(@SerializedName("sepet_yemekler") var cart : List<CartFoods>,
                             @SerializedName("success") var success: Int) {
}