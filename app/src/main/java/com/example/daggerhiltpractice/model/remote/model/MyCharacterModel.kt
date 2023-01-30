package com.example.daggerhiltpractice.model.remote.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MyCharacterModel(
    @Json(name = "name")
    val name:String,
    @Json(name = "image")
    val imgUrl:String
)
