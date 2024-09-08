package com.example.memorycard.data.repository

import androidx.lifecycle.LiveData
import com.example.memorycard.data.database.DaoDatabase
import com.example.memorycard.data.model.CardData
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val cardDao: DaoDatabase
): Repository {

    override suspend fun insert(card: CardData) {
        cardDao.insert(card)
    }

    override suspend fun delete(card: CardData) {
        cardDao.delete(card)
    }

    override suspend fun upDate(card: CardData) {
        cardDao.upDate(card)
    }

    override fun getAllCards(): LiveData<List<CardData>> {
        return cardDao.getAllCards()
    }
}