package com.example.likaida.myapplication

/**
 * Created by likaida on 2017/7/6.
 */
data class Forecasts(
		val id: Long,
		val date: Long,
		val description: String,
		val high: Int,
		val low: Int,
		val iconUrl: String)