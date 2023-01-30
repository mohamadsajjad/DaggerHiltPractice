package com.example.daggerhiltpractice.model.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.daggerhiltpractice.model.local.dao.MyCharacterDao
import com.example.daggerhiltpractice.model.local.entity.MyCharacterEntity

@Database(version = 1, entities = [MyCharacterEntity::class], exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun characterDao(): MyCharacterDao

}