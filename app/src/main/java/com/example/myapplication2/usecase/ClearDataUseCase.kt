package com.example.myapplication2.usecase

import com.example.myapplication2.data.repository.DrinkRepository

class ClearDataUseCase(private val drinkRepository: DrinkRepository) {
    fun execute() = drinkRepository.clear()
}