package com.example.myapplication2.presentation.main

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.myapplication2.R
import com.example.myapplication2.databinding.FragmentMainBinding
import com.example.myapplication2.domain.Drink
import com.example.myapplication2.presentation.drink.DrinkListAdapter
import com.example.myapplication2.presentation.utils.Constants.DRINK
import com.example.myapplication2.presentation.utils.Utils.show

class MainFragment : Fragment() {
    private var binding: FragmentMainBinding? = null
    private val viewModel by viewModels<MainViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setVMListener()
        setSearchBar()
        viewModel.randomDrinks()
    }

    private fun setSearchBar() {
        binding?.etSearch?.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(text: CharSequence?, p1: Int, p2: Int, p3: Int) {
                viewModel.search(text.toString())
            }

            override fun afterTextChanged(p0: Editable?) {

            }
        })
    }

    private fun setVMListener() {
        viewModel.drinks.observe(viewLifecycleOwner) { drinkList ->
            setDrinkList(drinkList)
        }
    }

    private fun setDrinkList(drinkList: List<Drink>) {
        if (drinkList.isNotEmpty()) showList(true)
        else showList(false)

        val drinkAdapter = DrinkListAdapter()
        drinkAdapter.submitList(drinkList)
        drinkAdapter.onDrinkSelected = { drink ->
            goToDetail(drink)
        }

        binding?.rvDrinkList?.apply {
            layoutManager = GridLayoutManager(this.context, 2)
            adapter = drinkAdapter
        }
    }

    private fun showList(show: Boolean) {
        binding?.let {
            it.rvDrinkList.show(show)
            it.iEmpty.root.visibility = if (!show) View.VISIBLE else View.GONE
        }
    }

    private fun goToDetail(drink: Drink) {
        val bundle = Bundle()
        bundle.putParcelable(DRINK, drink)

        findNavController().navigate(R.id.action_mainFragment_to_drinkDetailDialog, bundle)
    }

    override fun onDestroy() {
        viewModel.clear()
        super.onDestroy()
    }
}