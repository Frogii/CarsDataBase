package com.example.carsdatabase

import android.app.Application
import android.content.Context

class App : Application() {

    companion object {

        lateinit var instance: App
    }

    init {
        instance = this
    }

}