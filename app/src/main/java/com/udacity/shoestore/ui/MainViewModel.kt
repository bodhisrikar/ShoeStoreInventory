package com.udacity.shoestore.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class MainViewModel : ViewModel() {
    private val _shoeList = MutableLiveData<MutableList<Shoe>>()
    val shoeList: LiveData<MutableList<Shoe>>
        get() = _shoeList

    init {
        _shoeList.value = mutableListOf<Shoe>()
        loadShoes()
    }

    private fun loadShoes() {
        _shoeList.value!!.add(Shoe("Puma", 8.0, "Puma", "lightweight shoes", mutableListOf("", "")))
        _shoeList.value!!.add(
            Shoe(
                "Adidas",
                7.0,
                "Adidas",
                "lightweight shoes",
                mutableListOf("", "")
            )
        )
        _shoeList.value!!.add(Shoe("Nike", 9.0, "Nike", "lightweight shoes", mutableListOf("", "")))
        _shoeList.value!!.add(
            Shoe(
                "Rebook",
                8.0,
                "Rebook",
                "lightweight shoes",
                mutableListOf("", "")
            )
        )
    }
}