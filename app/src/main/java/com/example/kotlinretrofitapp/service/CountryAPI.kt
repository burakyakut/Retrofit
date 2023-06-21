package com.example.kotlinretrofitapp.service

import com.example.kotlinretrofitapp.model.CountryModel
import retrofit2.Call
import retrofit2.http.GET

interface CountryAPI {

    @GET("atilsamancioglu/IA19-DataSetCountries/master/countrydataset.json")
    fun getCountryData():Call<List<CountryModel>>
}