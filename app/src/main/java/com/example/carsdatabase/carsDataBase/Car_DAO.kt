package com.example.carsdatabase.carsDataBase

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.carsdatabase.carsDataBase.Car

@Dao
interface Car_DAO {

    @Insert
    fun saveCar(car: Car)

    @Query("select * from Car")
    fun readCars(): List<Car>

}