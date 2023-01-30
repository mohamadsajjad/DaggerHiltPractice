package com.example.daggerhiltpractice.model.local.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.daggerhiltpractice.model.local.entity.MyCharacterEntity

@Dao
interface MyCharacterDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addCharacter(character: MyCharacterEntity):Long

    @Update
    suspend fun updateCharacter(character: MyCharacterEntity)

    @Delete
    suspend fun deleteCharacter(character: MyCharacterEntity)

    @Query("SELECT * FROM character ORDER BY id ASC")
    fun fetchAllCharacter(): LiveData<List<MyCharacterEntity>>

    @Query("SELECT * FROM character WHERE id=:id")
    fun fetchCharacterById(id: Int): LiveData<MyCharacterEntity>

}