package com.example.myapplication2.framework.source

import com.example.myapplication2.data.source.IDrinkSource
import com.example.myapplication2.domain.Drink
import com.example.myapplication2.framework.client.Instance
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers

class DrinkSource : IDrinkSource {
    private val disposable = CompositeDisposable()
    private val retrofitInstance = Instance().getInstance()

    override fun clear() {
        disposable.clear()
    }

    override fun searchDrink(drink: String, callback: (List<Drink>) -> Unit) {

        val call = retrofitInstance?.drinkSearch(drink)

        call?.let {
            disposable.add(
                call.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({
                        callback.invoke(it.drinks)
                    }, {
                        callback.invoke(emptyList())
                    })
            )
        }
    }

    override fun randomDrinks(callback: (List<Drink>) -> Unit) {
        val call = retrofitInstance?.randomDrinks()

        call?.let {
            disposable.add(
                call.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({
                        callback.invoke(it.drinks)
                    }, {
                        callback.invoke(emptyList())
                    })
            )
        }
    }
}