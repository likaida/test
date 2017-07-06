package com.example.likaida.myapplication

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import org.jetbrains.anko.find

/**
 * Created by likaida on 2017/7/6.
 */
open class ItemViewHolder ( view: View) : RecyclerView.ViewHolder(view){//, val itemClick: (Forecast) -> Unit
	val tv:TextView=view.find(R.id.tv)
	val tv2:TextView=view.find(R.id.tv2)
}