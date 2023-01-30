package com.example.daggerhiltpractice.di

import com.example.daggerhiltpractice.model.local.entity.MyCharacterEntity
import com.example.daggerhiltpractice.model.remote.model.MyCharacterModel

object Transformer {
    fun convertCharacterModelToEntity(myCharacter: MyCharacterModel):MyCharacterEntity{
        return MyCharacterEntity(
            0,
            myCharacter.name,
            myCharacter.imgUrl
        )
    }
}