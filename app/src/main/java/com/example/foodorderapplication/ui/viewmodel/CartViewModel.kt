package com.example.foodorderapplication.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.foodorderapplication.data.entity.CartFoods
import com.example.foodorderapplication.data.repo.CartFoodsRepository
import com.example.foodorderapplication.data.repo.FoodsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CartViewModel @Inject constructor(var cfrepo: CartFoodsRepository):ViewModel(){
    var cartFoodsList= MutableLiveData<List<CartFoods>>()
    var nickname = "Meric"
    init {
        cartFoodsLoad()
    }
    fun cartFoodsLoad(){
        CoroutineScope(Dispatchers.Main).launch {
            try {
                cartFoodsList.value = cfrepo.carFoodsLoad(nickname)
            } catch (e: Exception) {
                Log.e("Hata", "Bu kullanıcı adına ait bir sepet bulunamadı.")
                cartFoodsList.value = emptyList()
            }
        }
    }
    fun remove(cart_food_id:Int,nickname: String){
        CoroutineScope(Dispatchers.Main).launch {
            cfrepo.remove(cart_food_id,nickname)
            cartFoodsLoad()
        }
    }
}