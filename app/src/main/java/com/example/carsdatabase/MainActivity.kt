package com.example.carsdatabase

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.carsdatabase.carsDataBase.Car
import com.example.carsdatabase.carsDataBase.Cars
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btAddCarActivity.setOnClickListener {
            val toAddCar = Intent(this, AddCarActivity::class.java)
            startActivity(toAddCar)
        }
        btFilter.setOnClickListener {
        }
    }

    override fun onResume() {

        super.onResume()

        var recAdapter: RecAdapter? = null
        Thread {

            recAdapter = RecAdapter(Cars.db.carDAO().readCars(), this)
            Log.d("TAG", Cars.db.carDAO().readCars().toString())
            runOnUiThread {
                recyclerView.adapter = recAdapter
                recyclerView.layoutManager = LinearLayoutManager(this)
            }
        }.start()
    }
}