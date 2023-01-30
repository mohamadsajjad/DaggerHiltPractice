package com.example.daggerhiltpractice.model.local.entity

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey


@Entity(tableName = "character", indices = [Index(value=["name","imgUrl"],unique=true)])
data class MyCharacterEntity(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val name:String,
    val imgUrl:String
)
