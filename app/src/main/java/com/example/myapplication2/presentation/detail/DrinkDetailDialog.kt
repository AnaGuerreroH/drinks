package com.example.myapplication2.presentation.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.bumptech.glide.Glide
import com.example.myapplication2.R
import com.example.myapplication2.databinding.FragmentDrinkDetailDialogBinding
import com.example.myapplication2.domain.Drink
import com.example.myapplication2.presentation.utils.Constants.DRINK

class DrinkDetailDialog : DialogFragment() {
    private var binding: FragmentDrinkDetailDialogBinding? = null
    private var drink: Drink? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            drink = it.getParcelable(DRINK, Drink::class.java)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDrinkDetailDialogBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setInformation()
    }

    private fun setInformation() {
        binding?.let { fragment ->
            if (drink?.strDrinkThumb?.isNotEmpty() == true) Glide.with(this.requireContext())
                .load(drink?.strDrinkThumb).placeholder(R.drawable.drink_placeholder).into(fragment.ivDrinkThumb)

            fragment.tvDrinkName.text = drink?.strDrink
            fragment.tvInstructions.text = drink?.strInstructions
        }
    }
}