package com.example.newproject.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    var retrofit: Retrofit? = null

    val client: Retrofit?
        get() {

            retrofit = Retrofit.Builder()
                .baseUrl("https://www.blogsonweb.com/rest/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit

        }
}