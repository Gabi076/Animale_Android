package com.example.animale.helpers.extensions

import android.util.Log

fun String.logErrorMessage(tag: String = "Animale"){
    Log.e(tag,this)
}