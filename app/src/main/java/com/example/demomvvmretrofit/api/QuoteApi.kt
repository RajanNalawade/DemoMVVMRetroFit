package com.example.demomvvmretrofit.api

import com.example.demomvvmretrofit.models.QuoteList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface QuoteApi {

    @GET("/quotes")
    suspend fun getQuoteList(@Query("page") page:Int) : Response<QuoteList>

    //base_url + "/quotes" + ?page=1
}