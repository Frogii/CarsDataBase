package com.example.carsdatabase

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.carsdatabase.carsDataBase.Car
import kotlinx.android.synthetic.main.card_car.view.*


class RecAdapter :
    RecyclerView.Adapter<RecAdapter.ViewHolder>() {

     private var arrayList: List<Car> = arrayListOf()

    fun setCarsList(list: List<Car>){
        arrayList = list
        notifyDataSetChanged()
    }

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