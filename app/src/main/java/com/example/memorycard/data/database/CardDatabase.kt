package com.example.memorycard.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.memorycard.data.model.CardData

@Database(entities = [CardData::class], version = 1, exportSchema = false)
abstract class CardDatabase: RoomDatabase() {

    abstract fun getDao(): DaoDatabase

}