package com.example.myapplication2.domain

import android.os.Parcelable
import androidx.recyclerview.widget.DiffUtil
import kotlinx.parcelize.Parcelize

@Parcelize
data class Drink(
    val strDrink: String, val strDrinkThumb: String, val strInstructions: String
) : Parcelable {
    companion object {
        object DiffCallback : DiffUtil.ItemCallback<Drink>() {
            override fun areItemsTheSame(oldItem: Drink, newItem: Drink): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: Drink, newItem: Drink): Boolean {
                return oldItem.strDrink == newItem.strDrink && oldItem.strDrinkThumb == newItem.strDrinkThumb && oldItem.strInstructions == newItem.strInstructions
            }
        }
    }
}