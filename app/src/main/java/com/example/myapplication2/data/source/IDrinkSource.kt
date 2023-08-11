package com.example.myapplication2.data.source

import com.example.myapplication2.domain.Drink

interface IDrinkSource {
    fun clear()

    fun searchDrink(drink:String, callback: (List<Drink>) -> Unit)

    fun randomDrinks(callback: (List<Drink>) -> Unit)
}