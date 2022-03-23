package com.example.mvvmexample.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmexample.models.QuotesList
import com.example.mvvmexample.repository.QuoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val repository: QuoteRepository) :ViewModel() {
    //once the main view model class loads we will request repository to get the quotes

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getQuotes(1)
        }

    }
    val quotes :LiveData<QuotesList>
    get() = repository.quotes

}