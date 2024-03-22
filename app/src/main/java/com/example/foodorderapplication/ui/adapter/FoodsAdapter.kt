package com.example.foodorderapplication.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
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

        design.imageViewFoodImage.setImageResource(
            mContext.resources.getIdentifier(
                food.food_image_name, "drawable", mContext.packageName
            )
        )

        design.textViewFoodPrice.text = food.food_price.toString()

        design.cardView.setOnClickListener {
            val amountString = design.textViewAmountText.text.toString()
            val amount = amountString.toIntOrNull() ?: 1

            val action = HomepageFragmentDirections.actionDetail(food = food, amount = amount)
            Navigation.findNavController(it).navigate(action)
        }

        design.cardButtonDeactive.setOnClickListener {
            design.cardButtonDeactive.visibility = View.INVISIBLE
            design.cardButtonActive.visibility = View.VISIBLE
            //TODO: Sepete eklencek ve sepette ise active kalacak
        }
        design.imageViewIncreaseButton.setOnClickListener {
            val amountString = design.textViewAmountText.text.toString()
            val currentAmount = amountString.toIntOrNull() ?: 1
            val newAmount = currentAmount + 1
            design.textViewAmountText.text = newAmount.toString()
        }

        design.imageViewReduceButton.setOnClickListener {
            val amountString = design.textViewAmountText.text.toString()
            val currentAmount = amountString.toIntOrNull() ?: 1
            val newAmount = currentAmount - 1
            design.textViewAmountText.text = newAmount.toString()
            if (newAmount <= 0) {
                Snackbar.make(
                    it, "${food.food_name} sepetten kaldırıldı", Snackbar
                        .LENGTH_SHORT
                ).show()
                remove(food.food_id)
                design.textViewAmountText.text = "1"
                design.cardButtonDeactive.visibility = View.VISIBLE
                design.cardButtonActive.visibility = View.INVISIBLE
            }
        }
    }

    override fun getItemCount(): Int {
        return foodsList.size
    }

    fun remove(food_id: Int) {
        Log.e("Yemek Kaldır", food_id.toString())
    }
}