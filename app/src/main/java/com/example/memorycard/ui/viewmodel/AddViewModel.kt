package com.example.memorycard.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.memorycard.data.model.CardData
import com.example.memorycard.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddViewModel @Inject constructor(
    private val repository: Repository
): ViewModel() {

    fun addNewCard(frontText: String, backText: String){
        viewModelScope.launch {
            repository.insert(CardData(frontText = frontText, backText = backText))
        }
    }
}