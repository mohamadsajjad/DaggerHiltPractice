package com.example.daggerhiltpractice.model.remote.repository

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.example.daggerhiltpractice.model.remote.api.ApiService
import com.example.daggerhiltpractice.model.remote.model.MyCharacterModel
import com.example.daggerhiltpractice.model.remote.model.MyCharacterResponse
import com.example.daggerhiltpractice.utils.ScreenState
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NetworkRepositoryImpl(
    private val api: ApiService,
    private val appContext: Application
) :NetworkRepository{

    override suspend fun fetchCharacters(page: String): MutableLiveData<ScreenState<List<MyCharacterModel>?>> {
        val client = api.fetchCharacters(page)
        val characterLiveData = MutableLiveData<ScreenState<List<MyCharacterModel>?>>()

        characterLiveData.postValue(ScreenState.Loading(null))
        client.enqueue(object : Callback<MyCharacterResponse>{
            override fun onResponse(
                call: Call<MyCharacterResponse>,
                response: Response<MyCharacterResponse>
            ) {
                if(response.isSuccessful){
                    characterLiveData.postValue(ScreenState.Success(response.body()?.result))
                }else{
                    characterLiveData.postValue(ScreenState.Error(response.code().toString(),null))
                }
            }

            override fun onFailure(call: Call<MyCharacterResponse>, t: Throwable) {
                characterLiveData.postValue(ScreenState.Error(t.message.toString(),null))
            }

        })
        return characterLiveData
    }
}