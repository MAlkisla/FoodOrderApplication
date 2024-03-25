package com.example.foodorderapplication.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.foodorderapplication.data.entity.Foods
import com.example.foodorderapplication.databinding.HomepageCardDesignBinding
import com.example.foodorderapplication.ui.fragment.HomepageFragmentDirections
import com.google.android.material.snackbar.Snackbar

class FoodsAdapter(var mContext: Context, var foodsList: List<Foods>) : RecyclerView
.Adapter<FoodsAdapter.HomepageCardDesingHolder>() {
    inner class HomepageCardDesingHolder(var design: HomepageCardDesignBinding) : RecyclerView
    .ViewHolder(design.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomepageCardDesingHolder {
        val binding =
            HomepageCardDesignBinding.inflate(LayoutInflater.from(mContext), parent, false)
        return HomepageCardDesingHolder(binding)
    }

    override fun onBindViewHolder(holder: HomepageCardDesingHolder, position: Int) {
        val food = foodsList.get(position)
        val design = holder.design

        design.textViewFoodName.text = food.food_name

        showImage(food,design)

        design.textViewFoodPrice.text = food.food_price.toString()

        design.cardView.setOnClickListener {
            val action = HomepageFragmentDirections.actionDetail(food = food)
            Navigation.findNavController(it).navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return foodsList.size
    }
    fun showImage(food: Foods,desing: HomepageCardDesignBinding){
        val url="http://kasimadalan.pe.hu/yemekler/resimler/${food.food_image_name}"
        Glide.with(mContext).load(url).override(120,120).into(desing.imageViewFoodImage)
    }
}