package com.example.demomvvmretrofit.view_models

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.demomvvmretrofit.models.QuoteList
import com.example.demomvvmretrofit.repository.QuotesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val quotesRepository: QuotesRepository) : ViewModel() {
    init {
        viewModelScope.launch(Dispatchers.IO){
            quotesRepository.getQuoteList(1)
        }
    }

    val quotes : LiveData<QuoteList>
    get() = quotesRepository.quotes
}