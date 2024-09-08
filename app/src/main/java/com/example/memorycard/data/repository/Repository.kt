package com.example.memorycard.data.repository

import androidx.lifecycle.LiveData
import com.example.memorycard.data.model.CardData

interface Repository {

    suspend fun insert(card: CardData)
    suspend fun delete(card: CardData)
    suspend fun upDate(card: CardData)
    fun getAllCards(): LiveData<List<CardData>>
}