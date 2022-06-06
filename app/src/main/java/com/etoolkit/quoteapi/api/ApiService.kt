package com.etoolkit.quoteapi.api

import com.etoolkit.quoteapi.model.Quote
import retrofit2.http.GET

interface ApiService  {

    @GET("random")
    suspend fun quotesRandomApis() : Quote

}