package com.example.carsdatabase.carsDataBase

import android.util.Log
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.carsdatabase.App

object Cars {
    lateinit var db: AppDB

    init {
        db = Room.databaseBuilder(App.instance, AppDB::class.java, "CarsDB").build()
    }
}

