package com.example.mvvmexample.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmexample.repository.QuoteRepository

class MainViewModelFactory(private val repository: QuoteRepository) :ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        return  MainViewModel(repository) as T
    }
}