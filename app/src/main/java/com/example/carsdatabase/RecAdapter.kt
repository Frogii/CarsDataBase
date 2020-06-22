package com.example.carsdatabase

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.carsdatabase.carsDataBase.Car
import kotlinx.android.synthetic.main.card_car.view.*

class RecAdapter(val arrayList: List<Car>, val context: Context) :
    RecyclerView.Adapter<RecAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(car: Car) {
            itemView.tvCarName.text = "Name: ${car.name}"
            itemView.tvCarAge.text = "Age: ${car.age}"
            itemView.tvCarColor.text = "Color: ${car.color}"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val card = LayoutInflater.from(parent.context).inflate(R.layout.card_car, parent, false)

        return ViewHolder(card)
    }

    override fun getItemCount(): Int {
        return arrayList.size

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(arrayList[position])

    }
}