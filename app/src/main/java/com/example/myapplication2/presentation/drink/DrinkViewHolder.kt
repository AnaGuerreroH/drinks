package com.example.myapplication2.presentation.drink

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.myapplication2.R
import com.example.myapplication2.databinding.ItemDrinkBinding
import com.example.myapplication2.domain.Drink

class DrinkViewHolder(
    private val binding: ItemDrinkBinding,
    private val onDrinkSelected: ((Drink) -> Unit)?
) : ViewHolder(binding.root) {
    fun bind(drink: Drink) {
        if (drink.strDrinkThumb.isNotEmpty())
            Glide.with(binding.root.context).load(drink.strDrinkThumb)
                .placeholder(R.drawable.drink_placeholder).into(binding.ivDrinkThumb)

        binding.tvDrinkName.text = drink.strDrink

        binding.root.setOnClickListener {
            onDrinkSelected?.invoke(drink)
        }
    }
}