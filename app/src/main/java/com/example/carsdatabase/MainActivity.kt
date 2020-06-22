package com.example.carsdatabase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

var carsDateBase = mutableListOf<Car>()

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val car1 = Car("Honda", 2020, "blue")
        val car2 = Car("Honda", 2010, "blue")
        val car3 = Car("Honda", 2003, "blue")
        val car4 = Car("Honda", 1997, "blue")
        val car5 = Car("Honda", 1992, "blue")
        val car6 = Car("Honda", 2005, "blue")

        carsDateBase.add(car1 )
        carsDateBase.add(car2 )
        carsDateBase.add(car3 )
        carsDateBase.add(car4 )
        carsDateBase.add(car5 )
        carsDateBase.add(car6 )





        val recAdapter = RecAdapter(carsDateBase, this)
        recyclerView.adapter = recAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)


        btAddCarActivity.setOnClickListener {
            val toAddCar = Intent(this, AddCarActivity::class.java)
            startActivity(toAddCar) }

        btFilter.setOnClickListener {
        }

    }

    override fun onRestart() {
        val name = intent.getStringExtra("name")
        val age = intent.getStringExtra("age")
        val color = intent.getStringExtra("color")
        if (!name.isNullOrEmpty()&&!age.isNullOrEmpty()&&!color.isNullOrEmpty()) {val newCar = Car(name,age.toInt() ,color )
            carsDateBase.add(newCar)}
        Log.d("list", carsDateBase.toString())

        val car10 = Car("BMW", 2000, "black")
        carsDateBase.add(car10)

        val recAdapter = RecAdapter(carsDateBase, this)
        recyclerView.adapter = recAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)


        super.onRestart()
    }
}