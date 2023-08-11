package com.example.myapplication2.presentation.drink

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.myapplication2.databinding.ItemDrinkBinding
import com.example.myapplication2.domain.Drink

class DrinkListAdapter : ListAdapter<Drink, DrinkViewHolder>(Drink.Companion.DiffCallback) {
    var onDrinkSelected: ((Drink)->Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DrinkViewHolder {
        return DrinkViewHolder(
            ItemDrinkBinding.inflate(LayoutInflater.from(parent.context), parent, false),
            onDrinkSelected
        )
    }

    override fun onBindViewHolder(holder: DrinkViewHolder, position: Int) {
        holder.bind(currentList[position])
    }
}