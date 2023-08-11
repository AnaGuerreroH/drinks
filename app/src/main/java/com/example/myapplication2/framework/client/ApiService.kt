package com.example.myapplication2.framework.client

import com.example.myapplication2.framework.client.response.DrinkSearchResponse
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("search.php?")
    fun drinkSearch(
        @Query("s") drink: String
    ): Observable<DrinkSearchResponse>

    @GET("random.php")
    fun randomDrinks(): Observable<DrinkSearchResponse>
}