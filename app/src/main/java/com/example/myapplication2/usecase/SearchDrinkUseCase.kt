package com.example.myapplication2.usecase

import com.example.myapplication2.data.repository.DrinkRepository
import com.example.myapplication2.domain.Drink
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SearchDrinkUseCase(private val drinkRepository: DrinkRepository) {
    suspend fun execute(drink: String, callback: (List<Drink>) -> Unit) =
        withContext(Dispatchers.IO) {
            drinkRepository.searchDrink(drink, callback)
        }
}