package com.example.myapplication2.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication2.R
import com.example.myapplication2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
    }
}