package com.etoolkit.quoteapi.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object QuoteRetrofitCreate  {

    private val BASE_URL = "https://api.quotable.io/"

    fun create() : ApiService {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(ApiService::class.java)
    }
}