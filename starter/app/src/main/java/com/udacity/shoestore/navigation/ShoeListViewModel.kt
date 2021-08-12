package com.udacity.shoestore.navigation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeListViewModel : ViewModel() {

    private val _shoes = MutableLiveData<List<Shoe>>()
    val shoes: LiveData<List<Shoe>>
        get() = _shoes

    init {
        val shoesList = mutableListOf<Shoe>()
        _shoes.value = shoesList
    }

    fun addShoe(name: String, size: Double, company: String, description: String) {
        val list = _shoes.value?.toMutableList()
        list?.add(
            Shoe.create(
                name = name,
                size = size,
                company = company,
                description = description
            )
        )
        list?.let {
            _shoes.postValue(it)
        }
    }

}