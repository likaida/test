package com.example.likaida.myapplication

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.likaida.myapplication.extensions.ctx

/**
 * Created by likaida on 2017/7/1.
 */
class ForecastListAdapter(val weekForecast: ForecastList) : RecyclerView.Adapter<ItemViewHolder>() {
	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
		val view = LayoutInflater.from(parent.ctx).inflate(R.layout.item_forecast, parent, false)
		return ItemViewHolder(view)
	}

	override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
		holder.tv.text = weekForecast[position].description
	}

	override fun getItemCount(): Int = weekForecast.size
}