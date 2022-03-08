package com.example.islami.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiManger {
    companion object{
        private  var retrofit: Retrofit ?=null
        private fun getInstance() : Retrofit{
              if(retrofit == null){
                  retrofit = Retrofit
                      .Builder()
                      .baseUrl("https://www.mp3quran.net/")
                      .addConverterFactory(GsonConverterFactory.create()).build()
              }
            return retrofit!!
        }
        fun getApi():WebInterfaces{
            return getInstance().create(WebInterfaces::class.java)
        }
    }
}