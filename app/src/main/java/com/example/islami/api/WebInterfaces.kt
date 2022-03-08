package com.example.islami.api

import retrofit2.Call
import retrofit2.http.GET

interface WebInterfaces  {
    @GET("api/radio/radio_ar.json")
    fun getRadiosChannel(): Call<RadioResponse>
}