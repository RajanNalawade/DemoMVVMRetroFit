package com.example.demomvvmretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.SearchView.OnQueryTextListener
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.demomvvmretrofit.adapters.QuoteAdapter
import com.example.demomvvmretrofit.api.QuoteApi
import com.example.demomvvmretrofit.api.RetrofitHelper
import com.example.demomvvmretrofit.databinding.ActivityMainBinding
import com.example.demomvvmretrofit.repository.QuotesRepository
import com.example.demomvvmretrofit.view_models.MainViewModel
import com.example.demomvvmretrofit.view_models.MainViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val mainViewModel: MainViewModel by viewModels<MainViewModel>()

    lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var adapter : QuoteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        /*val api = RetrofitHelper.getRetrofitInstance().create(QuoteApi::class.java)
        val repo = QuotesRepository(api)
        mainViewModel = ViewModelProvider(this, MainViewModelFactory(repo))[MainViewModel::class.java]*/

        reverseString("rajan")

        binding.rvQuote.adapter = adapter

        mainViewModel.quotes.observe(this, Observer {
            Log.d("QuoteList" , "${it.results.toString()}")
            adapter.submitList(it.results)
        })
    }

    fun reverseString(input : String){
        var data : String = ""
        //input.forEachIndexed { index, c -> data = c + data }
        for (i in input.toCharArray()){
            data = i + data
        }
        print("reverse String - $data")
    }
}