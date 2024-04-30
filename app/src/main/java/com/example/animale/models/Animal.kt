package com.example.animale.models

class Animal(val name: String, val continent: String) {
    val color: Long = when (continent) {
        "Europe" -> 0xFF008A00
        "Africa" -> 0xFFE3C700
        "Asia" -> 0xFFE51400
        "North America" -> 0xFFA0522C
        "South America" -> 0xFFFA6900
        "Australia" -> 0xFF6A00FF
        "Antarctica" -> 0xFF1BA0E1
        else -> 0xFF000000
    }
}