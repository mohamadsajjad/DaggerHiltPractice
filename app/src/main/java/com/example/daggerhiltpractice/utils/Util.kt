package com.example.daggerhiltpractice.utils

import android.app.Activity
import android.util.Log
import androidx.fragment.app.Fragment
import com.example.daggerhiltpractice.MyApp

fun Fragment.logData(message: String) {
    if (MyApp.IS_DEBUG)
        Log.i("com.example.daggerhiltpractice", "${this.javaClass.simpleName} Log --> $message")
}

fun Activity.logData(message: String) {
    if (MyApp.IS_DEBUG)
        Log.i("com.example.daggerhiltpractice", "${this.javaClass.simpleName} Log --> $message")
}

