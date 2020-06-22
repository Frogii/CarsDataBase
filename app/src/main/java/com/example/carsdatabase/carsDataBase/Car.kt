package com.example.carsdatabase.carsDataBase

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Car {
    @PrimaryKey(autoGenerate = true)
    var carId: Int = 0

    var name: String = ""

    var age: Int = 0

    var color: String = ""

}