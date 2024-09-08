package com.example.memorycard.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.memorycard.data.model.CardData

@Dao
interface DaoDatabase {

    @Insert(onConflict = OnConflictStrategy.NONE)
    suspend fun insert(card: CardData)

    @Update
    suspend fun upDate(card: CardData)

    @Delete
    suspend fun delete(card:CardData)

    @Query("SELECT * FROM CARDS ORDER BY id DESC")
    fun getAllCards(): LiveData<List<CardData>>
}