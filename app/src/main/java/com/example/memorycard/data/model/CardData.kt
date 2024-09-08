package com.example.memorycard.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "cards")
data class CardData(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val frontText: String,
    val backText: String,
    val isKnown: Boolean = false,
    val isFavourite: Boolean = false
):Serializable
