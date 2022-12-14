package com.ffescara.myfinance.network

import com.ffescara.myfinance.data.Kurs
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

private val BASE_URL = "https://anyapi.io/"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface KursAPI {
    @GET("api/v1/exchange/rates?base=USD&apiKey=gdci18ngnh86pra08aqshohb5a8vuavjgg04ksbo42g9r0dp00kde8")
    suspend fun GetRates(): Kurs
}

object Api {
    val kursAPI: KursAPI by lazy {
        retrofit.create(KursAPI::class.java)
    }
}