package com.example.foodorderapplication.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.foodorderapplication.data.entity.Foods
import com.example.foodorderapplication.databinding.HomepageCardDesignBinding

class FoodsAdapter(var mContext: Context, var foodsList: List<Foods>): RecyclerView
    .Adapter<FoodsAdapter.HomepageCardDesingHolder>() {
    inner class HomepageCardDesingHolder(var design: HomepageCardDesignBinding) : RecyclerView
    .ViewHolder(design.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomepageCardDesingHolder {
        val binding = HomepageCardDesignBinding.inflate(LayoutInflater.from(mContext),parent,false)
        return HomepageCardDesingHolder(binding)
    }
    override fun onBindViewHolder(holder: HomepageCardDesingHolder, position: Int) {
        val food = foodsList.get(position)
        val design = holder.design

        design.textViewFoodName.text = food.food_name

        design.imageViewFoodImage.setImageResource(
            mContext.resources.getIdentifier(
                food.food_image_name, "drawable", mContext.packageName
            )
        )

        design.textViewFoodPrice.text = food.food_price.toString()
    }

    override fun getItemCount(): Int {
        return foodsList.size
    }
}