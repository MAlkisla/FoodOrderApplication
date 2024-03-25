package com.example.foodorderapplication.data.entity

import com.google.gson.annotations.SerializedName

class FoodsResponse(@SerializedName("yemekler") var foodsList: List<Foods>,
                    @SerializedName("success") var success: Int) {
}