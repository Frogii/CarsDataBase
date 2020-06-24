package com.example.carsdatabase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.carsdatabase.carsDataBase.Car
import com.example.carsdatabase.carsDataBase.Cars
import kotlinx.android.synthetic.main.activity_add_car.*

class AddCarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_car)

        val name = etCarName.text
        val age = etCarAge.text
        val color = etCarColor.text

        btAddNewCar.setOnClickListener {
            val car = Car()
            car.age = age.toString().toInt()
            car.name = name.toString()
            car.color = color.toString()

            Thread {
                Cars.db.carDAO().saveCar(car)
            }.start()

        }
    }
}