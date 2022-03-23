package com.example.mvvmexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmexample.api.QuoteService
import com.example.mvvmexample.api.RetrofitHelper
import com.example.mvvmexample.repository.QuoteRepository
import com.example.mvvmexample.viewmodels.MainViewModel
import com.example.mvvmexample.viewmodels.MainViewModelFactory
import retrofit2.create

class MainActivity : AppCompatActivity() {

    lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //quoteService object will created by RetroFit Instance

        val quoteService = RetrofitHelper.getInstance().create(QuoteService::class.java)

        //here we have created object of Repository which need object of Quote Service class so we will create quoteService created above
        val repository = QuoteRepository(quoteService)
        //here the object for main View model will be created by MainView model which needs repository as parameter so we will create repository
        mainViewModel = ViewModelProvider(this,MainViewModelFactory(repository)).get(MainViewModel::class.java)
        mainViewModel.quotes.observe(this,{

            Log.d("this is demo ",it.toString())
        })
    }
}