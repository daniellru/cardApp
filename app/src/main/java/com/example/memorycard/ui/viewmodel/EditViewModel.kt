package com.example.memorycard.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.memorycard.data.model.CardData
import com.example.memorycard.data.repository.RepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EditViewModel @Inject constructor(
     private val repositoryImpl: RepositoryImpl): ViewModel() {

    fun onUpdateClick(cardData: CardData){
        viewModelScope.launch {
            repositoryImpl.upDate(cardData)
        }
    }

    fun onDeleteClick(cardData: CardData){
        viewModelScope.launch {
            repositoryImpl.delete(cardData)
            HomeViewModel.currentIndex = 0
        }
    }
}