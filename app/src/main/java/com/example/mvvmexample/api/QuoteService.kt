package com.example.mvvmexample.api

import com.example.mvvmexample.models.QuotesList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface QuoteService {

            //all kind of service like get , post , update have to write here same like DAO
            // DAO is also interface

    //base url is  https://quotable.io/quotes?page=1

    @GET("/quotes")
    suspend fun getQuotes(@Query("page" )page:Int):Response<QuotesList>
}