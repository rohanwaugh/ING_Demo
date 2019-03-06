package com.cts.demo

import retrofit2.Call
import retrofit2.http.GET

interface API {

    @GET("marvel")
    fun getHeros():Call<List<Hero>>

    companion object {
        const val BASE_URL = "https://simplifiedcoding.net/demos/"
    }
}