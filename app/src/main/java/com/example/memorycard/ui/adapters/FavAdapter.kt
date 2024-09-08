package com.example.memorycard.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.memorycard.data.model.CardData
import com.example.memorycard.databinding.FavItemBinding

class FavAdapter: ListAdapter<CardData, FavAdapter.FavViewHolder>(CardDiffCallBack()) {

    inner class FavViewHolder(val binding: FavItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavViewHolder {
        val binding = FavItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FavViewHolder(binding)
    }


    override fun onBindViewHolder(holder: FavViewHolder, position: Int) {
        val currentItem = getItem(position)
        holder.binding.tvFavWord.text = currentItem.frontText
    }

    class CardDiffCallBack: DiffUtil.ItemCallback<CardData>(){
        override fun areItemsTheSame(oldItem: CardData, newItem: CardData): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: CardData, newItem: CardData): Boolean {
            return oldItem == newItem
        }

    }

}