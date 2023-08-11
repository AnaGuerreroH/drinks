package com.example.myapplication2.presentation.utils

import android.view.View

object Utils {
    fun View.show(show: Boolean) {
        if (show) this.visibility = View.VISIBLE else View.GONE
    }
}