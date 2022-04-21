package com.example.project

import java.util.ArrayList

object LandmarkContent {
    val ITEMS: MutableList<LandmarkItem> = ArrayList()

    fun addItem(item: LandmarkItem) {
        ITEMS.add(item)
    }

    //create the object's parameters
    data class LandmarkItem(
        val name: String, val latitude: Double, val longitude: Double
    )
}