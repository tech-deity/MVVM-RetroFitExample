package com.example.mvvmexample.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mvvmexample.api.QuoteService
import com.example.mvvmexample.models.QuotesList

//repository take interface as parameter like in room it take dao here it will take QuoteService
class QuoteRepository(private val quoteService: QuoteService) {

    //quotes list Mutable LiveData
    private val quotesLiveData = MutableLiveData<QuotesList>()
    //public liveData

    val quotes: LiveData<QuotesList>
    get() =quotesLiveData

    //this function will be called from our view model class a
    suspend fun getQuotes(page: Int) {

        val result = quoteService.getQuotes(page)
        //check if the result is null no data get from API
        if(result?.body() != null){
            //the result will be QuoteList we need to create an LiveDATA for quotes created above
            // save the response result.body() in the live data
            quotesLiveData.postValue(result.body())
        }

    }


}