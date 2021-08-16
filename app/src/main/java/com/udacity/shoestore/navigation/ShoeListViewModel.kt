package com.udacity.shoestore.navigation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe
import java.util.*

class ShoeListViewModel : ViewModel() {

    private val _shoes = MutableLiveData<List<Shoe>>()
    val shoes: LiveData<List<Shoe>>
        get() = _shoes

    val name = MutableLiveData<String>()

    val size = MutableLiveData<String>()

    val company = MutableLiveData<String>()

    val description = MutableLiveData<String>()

    init {
        val shoesList = mutableListOf<Shoe>()
        _shoes.value = shoesList
    }

    fun addShoe() {
        val list = mutableListOf<Shoe>()
        list.addAll(_shoes.value ?: emptyList())

        list.add(
            Shoe.create(
                name.value.toString(),
                size.value.toString().toDouble(),
                company.value.toString(),
                description.value.toString()
            )
        )
        list.let {
            _shoes.postValue(it)
        }
        name.postValue("")
        size.postValue("")
        company.postValue("")
        description.postValue("")
    }

}