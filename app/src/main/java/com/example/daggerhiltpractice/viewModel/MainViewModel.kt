package com.example.daggerhiltpractice.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.daggerhiltpractice.di.Transformer
import com.example.daggerhiltpractice.model.local.entity.MyCharacterEntity
import com.example.daggerhiltpractice.model.local.repository.DatabaseRepository
import com.example.daggerhiltpractice.model.remote.model.MyCharacterModel
import com.example.daggerhiltpractice.model.remote.repository.NetworkRepository
import com.example.daggerhiltpractice.utils.ScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    application: Application,
    private val networkRepository: NetworkRepository,
    private val databaseRepository: DatabaseRepository
) : AndroidViewModel(application) {

    suspend fun getCharacterFromRemote(page:String):MutableLiveData<ScreenState<List<MyCharacterModel>?>> {
        return networkRepository.fetchCharacters(page)
    }

    suspend fun getCharacterFromLocal(): LiveData<List<MyCharacterEntity>> {
        return databaseRepository.fetchAllCharacter()
    }

    suspend fun addCharacterToDatabase(myCharacterEntity: MyCharacterEntity):Long{
        return databaseRepository.addCharacter(myCharacterEntity)
    }

    fun saveDataToDatabase(data:List<MyCharacterModel>){
        viewModelScope.launch {
            data.forEach {
                addCharacterToDatabase(Transformer.convertCharacterModelToEntity(it))
            }
        }
    }


}