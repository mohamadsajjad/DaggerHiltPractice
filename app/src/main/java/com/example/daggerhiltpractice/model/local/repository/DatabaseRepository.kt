package com.example.daggerhiltpractice.model.local.repository

import androidx.lifecycle.LiveData
import com.example.daggerhiltpractice.model.local.dao.MyCharacterDao
import com.example.daggerhiltpractice.model.local.entity.MyCharacterEntity

class DatabaseRepository(private val characterDao: MyCharacterDao) {

    suspend fun addCharacter(character: MyCharacterEntity):Long {
        return characterDao.addCharacter(character)
    }

    suspend fun updateCharacter(character: MyCharacterEntity) {
        characterDao.updateCharacter(character)
    }

    suspend fun deleteCharacter(character: MyCharacterEntity) {
        characterDao.deleteCharacter(character)
    }

    fun fetchAllCharacter(): LiveData<List<MyCharacterEntity>> {
        return characterDao.fetchAllCharacter()
    }

    fun fetchCharacterById(id:Int): LiveData<MyCharacterEntity> {
        return characterDao.fetchCharacterById(id)
    }
}