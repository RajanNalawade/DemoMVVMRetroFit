package com.example.demomvvmretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.demomvvmretrofit.api.QuoteApi
import com.example.demomvvmretrofit.api.RetrofitHelper
import com.example.demomvvmretrofit.repository.QuotesRepository
import com.example.demomvvmretrofit.view_models.MainViewModel
import com.example.demomvvmretrofit.view_models.MainViewModelFactory

class MainActivity : AppCompatActivity() {

    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val api = RetrofitHelper.getRetrofitInstance().create(QuoteApi::class.java)
        val repo = QuotesRepository(api)
        mainViewModel = ViewModelProvider(this, MainViewModelFactory(repo))[MainViewModel::class.java]

        mainViewModel.quotes.observe(this, Observer {
            Log.d("QuoteList" , "${it.results.toString()}")
        })
    }
}