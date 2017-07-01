package com.example.likaida.myapplication

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.TextView

/**
 * Created by likaida on 2017/7/1.
 */
class ForecastListAdapter(val items: List<String>) : RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {

	override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder = ViewHolder(TextView(parent?.context))

	override fun onBindViewHolder(holder: ViewHolder, position: Int) {
		holder.textView.text = items[position]
	}

	override fun getItemCount(): Int = items.size

	class ViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)
}