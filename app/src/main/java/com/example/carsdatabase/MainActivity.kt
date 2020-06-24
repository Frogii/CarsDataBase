package com.example.carsdatabase

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.preference.PreferenceManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.carsdatabase.carsDataBase.Car
import com.example.carsdatabase.carsDataBase.Cars
import com.example.carsdatabase.filter.FilterActivity
import com.example.carsdatabase.filter.FilterFragment
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {


    private lateinit var typeOfFilter: String
    private val adapter = RecAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btAddCarActivity.setOnClickListener {
            val toAddCar = Intent(this, AddCarActivity::class.java)
            startActivity(toAddCar)
        }
        btFilter.setOnClickListener {
            val intent = Intent(this, FilterActivity::class.java)
            startActivity(intent)
        }

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

    }

    override fun onResume() {
        super.onResume()

        val pref = PreferenceManager.getDefaultSharedPreferences(this)

        typeOfFilter = pref.getString("filter_preference_list", "").toString()
        Log.d("TAG", "$typeOfFilter")

        var cars: List<Car>? = null
        when (typeOfFilter) {
            "Name" -> setList{  Cars.db.carDAO().getAllOrderByName()}


            "Age" -> setList{  Cars.db.carDAO().getAllOrderByAge()}
            "Color" -> setList{  Cars.db.carDAO().getAllOrderByColor()}
            else -> setList{  Cars.db.carDAO().readCars()}

        }
    }

    private fun setList(cars: () -> List<Car>) {
        Thread {
            var list = cars()
            runOnUiThread { adapter.setCarsList(list) }
        }.start()

    }

}