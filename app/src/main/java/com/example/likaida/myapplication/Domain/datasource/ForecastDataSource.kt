package com.example.likaida.myapplication.Domain.datasource

import com.example.likaida.myapplication.Forecast
import com.example.likaida.myapplication.ForecastList

interface ForecastDataSource {

    fun requestForecastByZipCode(zipCode: Long, date: Long): ForecastList?

    fun requestDayForecast(id: Long): Forecast?

}