package com.plcoding.weatherapp.domain.repository

import com.plcoding.weatherapp.domain.util.Resource
import com.plcoding.weatherapp.domain.weather.WeatherInfo

interface WeatherRepository {
    suspend fun getWeatherData(let: Double, long: Double):Resource<WeatherInfo>
}