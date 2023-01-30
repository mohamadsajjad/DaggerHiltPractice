package com.example.daggerhiltpractice.model.remote.api

import com.example.daggerhiltpractice.model.remote.model.MyCharacterResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("character")
    fun fetchCharacters(@Query("page") page:String):Call<MyCharacterResponse>
}