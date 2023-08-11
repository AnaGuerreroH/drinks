package com.example.myapplication2.framework.client

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import com.example.myapplication2.framework.utils.Constants.TIMEOUT
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class Instance {
    private val BASE_URL = "https://www.thecocktaildb.com/api/json/v1/1/"

    private var retrofit: Retrofit? = null

    private val okHttpClient = OkHttpClient().newBuilder()
        .connectTimeout(TIMEOUT, TimeUnit.SECONDS)
        .readTimeout(TIMEOUT, TimeUnit.SECONDS)
        .writeTimeout(TIMEOUT, TimeUnit.SECONDS)
        .build()

    fun getInstance(): ApiService? {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        return retrofit?.create(ApiService::class.java)
    }
}