package com.example.likaida.myapplication.data.server

import com.google.gson.Gson

/**
 * Created by likaida on 2017/7/7.
 */
class ForecastByZipCodeRequest(val zipCode: Long, val gson: Gson = Gson()) {
	companion object {
		private val APP_ID = "15646a06818f61f7b8d7823ca833e1ce"
		private val URL = "http://api.openweathermap.org/data/2.5/forecast/daily?mode=json&units=metric&cnt=7"
		private val COMPLETE_URL = "$URL&APPID=$APP_ID&q="
	}

	fun execute(): ForecastResult {
		val forecastJsonStr = java.net.URL(COMPLETE_URL + zipCode).readText()
		return Gson().fromJson(forecastJsonStr, ForecastResult::class.java)
	}
}