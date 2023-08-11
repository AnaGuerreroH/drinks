package com.example.myapplication2.usecase

import com.example.myapplication2.data.repository.DrinkRepository
import com.example.myapplication2.domain.Drink
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetRandomDrinksUseCase(private val drinksRepository: DrinkRepository) {
    suspend fun execute(callback: (List<Drink>) -> Unit) = withContext(Dispatchers.IO) {
        drinksRepository.randomDrinks(callback)
    }
}