package com.example.likaida.myapplication.data.db

import byId
import clear
import com.example.likaida.myapplication.Domain.datasource.ForecastDataSource
import com.example.likaida.myapplication.ForecastList
import org.jetbrains.anko.db.insert
import org.jetbrains.anko.db.select
import parseList
import parseOpt
import toVarargArray
import java.util.*

class ForecastDb(val forecastDbHelper: ForecastDbHelper = ForecastDbHelper.instance,
				 val dataMapper: DbDataMapper = DbDataMapper()) : ForecastDataSource {

	override fun requestForecastByZipCode(zipCode: Long, date: Long) = forecastDbHelper.use {

		val dailyRequest = "${DayForecastTable.CITY_ID} = ? AND ${DayForecastTable.DATE} >= ?"
		val dailyForecast = select(DayForecastTable.NAME)
				.whereSimple(dailyRequest, zipCode.toString(), date.toString())
				.parseList { DayForecast(HashMap(it)) }

		val city = select(CityForecastTable.NAME)
				.whereSimple("${CityForecastTable.ID} = ?", zipCode.toString())
				.parseOpt { CityForecast(HashMap(it), dailyForecast) }

		city?.let { dataMapper.convertToDomain(it) }
	}

	override fun requestDayForecast(id: Long) = forecastDbHelper.use {
		val forecast = select(DayForecastTable.NAME).byId(id).
				parseOpt { DayForecast(HashMap(it)) }

		forecast?.let { dataMapper.convertDayToDomain(it) }
	}

	fun saveForecast(forecast: ForecastList) = forecastDbHelper.use {

		clear(CityForecastTable.NAME)
		clear(DayForecastTable.NAME)

		with(dataMapper.convertFromDomain(forecast)) {
			insert(CityForecastTable.NAME, *map.toVarargArray())
			dailyForecast.forEach { insert(DayForecastTable.NAME, *it.map.toVarargArray()) }
		}
	}
}
