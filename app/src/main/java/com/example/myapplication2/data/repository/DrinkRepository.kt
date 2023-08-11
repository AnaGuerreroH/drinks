package com.example.myapplication2.data.repository

import com.example.myapplication2.data.source.IDrinkSource
import com.example.myapplication2.domain.Drink
import com.example.myapplication2.framework.source.DrinkSource

class DrinkRepository {
    private val drinkSource: IDrinkSource = DrinkSource()

    fun clear() = drinkSource.clear()

    fun searchDrink(drink: String, callback: (List<Drink>) -> Unit) =
        drinkSource.searchDrink(drink, callback)

    fun randomDrinks(callback: (List<Drink>) -> Unit) = drinkSource.randomDrinks(callback)
}