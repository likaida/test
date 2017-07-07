package com.example.likaida.myapplication.Domain.commands

import com.example.likaida.myapplication.Domain.datasource.ForecastProvider
import com.example.likaida.myapplication.ForecastList

class RequestForecastCommand(
        val zipCode: Long,
        val forecastProvider: ForecastProvider = ForecastProvider()) :
        Command<ForecastList> {

    companion object {
        val DAYS = 7
    }

    override fun execute() = forecastProvider.requestByZipCode(zipCode, DAYS)
}