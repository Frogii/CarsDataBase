package com.example.carsdatabase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_add_car.*

class AddCarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_car)

        val name = etCarName.text
        val age = etCarAge.text
        val color = etCarColor.text

        btAddNewCar.setOnClickListener {
            val i = Intent(this, MainActivity::class.java)
            i.putExtra("name", name)
            i.putExtra("name", age)
            i.putExtra("name", color)
        }



    }
}