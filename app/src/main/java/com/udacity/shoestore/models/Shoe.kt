package com.udacity.shoestore.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
data class Shoe(
    var name: String, var size: Double, var company: String, var description: String,
    val images: List<String> = mutableListOf()
) : Parcelable {
    companion object {
        fun create(
            name: String,
            size: Double,
            company: String,
            description: String
        ): Shoe {
            return Shoe(name, size, company, description)
        }
    }
}