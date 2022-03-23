package com.example.mvvmexample.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
//we have to create the instance of retrofit same as we create in room DB we create Instance of DATAbase

object RetrofitHelper {
    private const val BASE_URL = "https://quotable.io/"

    fun getInstance():Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}

//now we have to create the repository which will act like bridge between the web service and View Model for that create the repository package
