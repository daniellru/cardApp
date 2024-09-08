package com.example.memorycard.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.memorycard.data.model.CardData
import com.example.memorycard.data.repository.RepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: RepositoryImpl
) : ViewModel() {

    private val _cardList = MutableLiveData<List<CardData>>()
    val cardList: LiveData<List<CardData>> get() = _cardList


    companion object{
        var currentIndex = 0
    }

    init {
        fetchData()
    }

    fun onItemClick(){
        _cardList.value?.let { list ->
            if(currentIndex < list.size -1){
                currentIndex++
                _cardList.value = list
            }
        }
    }

    fun getCurrentCard(): CardData? {
        return _cardList.value?.getOrNull(currentIndex)
    }

    fun isCardListEmpty(): Boolean{
        return _cardList.value.isNullOrEmpty()
    }

    private fun fetchData() {
        repository.getAllCards().observeForever { cards ->
            _cardList.value = cards
        }
    }
}