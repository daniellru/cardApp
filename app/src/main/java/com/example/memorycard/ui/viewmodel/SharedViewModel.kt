package com.example.memorycard.ui.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.memorycard.data.model.CardData
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SharedViewModel @Inject constructor(): ViewModel() {

    private val _favCard = MutableLiveData<List<CardData>>()
    val favCard: LiveData<List<CardData>> get() = _favCard

    private val currentFavList = mutableListOf<CardData>()

    fun onFavClicked(card: CardData){
        currentFavList.add(card)
        _favCard.value = currentFavList.toList()
        Log.e("SharedList", "CurrentFav: ${currentFavList}")
    }
}