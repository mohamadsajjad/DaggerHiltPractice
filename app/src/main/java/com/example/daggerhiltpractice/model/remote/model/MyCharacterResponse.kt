package com.example.daggerhiltpractice.model.remote.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MyCharacterResponse(
    @Json(name = "results")
    val result: List<MyCharacterModel>
)