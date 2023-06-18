package com.example.demomvvmretrofit.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.demomvvmretrofit.api.QuoteApi
import com.example.demomvvmretrofit.models.QuoteList
import retrofit2.Response
import javax.inject.Inject

class QuotesRepository @Inject constructor(private val quoteApi: QuoteApi) {

    private val quotesLiveData = MutableLiveData<QuoteList>()

    val quotes : LiveData<QuoteList>
    get() = quotesLiveData

    suspend fun getQuoteList(page:Int){

        val result = quoteApi.getQuoteList(page)
        if (result.body()!=null){
            quotesLiveData.postValue(result.body())
        }
    }
}