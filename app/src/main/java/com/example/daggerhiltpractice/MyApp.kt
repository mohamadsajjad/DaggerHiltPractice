package com.example.daggerhiltpractice

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyApp : Application() {

    companion object {
        const val IS_DEBUG: Boolean = true
    }


}