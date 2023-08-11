package com.example.myapplication2.presentation.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication2.data.repository.DrinkRepository
import com.example.myapplication2.domain.Drink
import com.example.myapplication2.usecase.ClearDataUseCase
import com.example.myapplication2.usecase.GetRandomDrinksUseCase
import com.example.myapplication2.usecase.SearchDrinkUseCase
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val drinkRepository = DrinkRepository()

    private val _drinks = MutableLiveData<List<Drink>>()
    val drinks: LiveData<List<Drink>> get() = _drinks

    fun randomDrinks() {
        viewModelScope.launch {
            GetRandomDrinksUseCase(drinkRepository).execute { drinksList ->
                _drinks.value = drinksList
            }
        }
    }

    fun search(drink: String) {
        viewModelScope.launch {
            SearchDrinkUseCase(drinkRepository).execute(drink) { drinksList ->
                _drinks.value = drinksList
            }
        }
    }

    fun clear() {
        ClearDataUseCase(drinkRepository).execute()
    }
}