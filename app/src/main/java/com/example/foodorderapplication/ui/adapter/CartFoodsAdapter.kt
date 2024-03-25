package com.example.foodorderapplication.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.foodorderapplication.data.entity.CartFoods
import com.example.foodorderapplication.data.entity.Foods
import com.example.foodorderapplication.databinding.CartCardDesignBinding
import com.example.foodorderapplication.databinding.HomepageCardDesignBinding
import com.example.foodorderapplication.ui.viewmodel.CartViewModel
import com.google.android.material.snackbar.Snackbar

class CartFoodsAdapter (var mContext: Context, var cartFoodsList: List<CartFoods>,var viewModel: CartViewModel) :
    RecyclerView
.Adapter<CartFoodsAdapter.CartCardDesingHolder>() {
    inner class CartCardDesingHolder(var design: CartCardDesignBinding) : RecyclerView
    .ViewHolder(design.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartCardDesingHolder {
        val binding =
            CartCardDesignBinding.inflate(LayoutInflater.from(mContext), parent, false)
        return CartCardDesingHolder(binding)
    }

    override fun onBindViewHolder(holder: CartCardDesingHolder, position: Int) {
        val cartFoods = cartFoodsList.get(position)
        val design = holder.design

        design.textViewFoodName.text = cartFoods.food_name

        showImage(cartFoods,design)

        design.textViewFoodPrice.text = cartFoods.food_price.toString()

        design.textViewAmount.text = cartFoods.food_order_amount.toString()
        design.imageViewRemove.setOnClickListener {
            Snackbar.make(it,"${cartFoods.food_name} sepetten kaldırılsın mı?", Snackbar.LENGTH_SHORT)
                .setAction("Evet"){
                    viewModel.remove(cartFoods.cart_food_id,cartFoods.nickname)
                }.show()
        }

    }

    override fun getItemCount(): Int {
        return cartFoodsList.size
    }

    fun showImage(food: CartFoods, desing: CartCardDesignBinding){
        val url="http://kasimadalan.pe.hu/yemekler/resimler/${food.food_image_name}"
        Glide.with(mContext).load(url).override(120,120).into(desing.imageViewFoodImage)
    }
}