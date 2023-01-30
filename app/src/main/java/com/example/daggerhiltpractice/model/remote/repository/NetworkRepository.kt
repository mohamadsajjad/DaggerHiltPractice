package com.example.daggerhiltpractice.model.remote.repository

import androidx.lifecycle.MutableLiveData
import com.example.daggerhiltpractice.model.remote.model.MyCharacterModel
import com.example.daggerhiltpractice.utils.ScreenState

interface NetworkRepository {
    suspend fun fetchCharacters(page:String):MutableLiveData<ScreenState<List<MyCharacterModel>?>>
}