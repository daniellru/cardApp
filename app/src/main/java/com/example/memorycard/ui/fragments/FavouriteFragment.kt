package com.example.memorycard.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.memorycard.R
import com.example.memorycard.databinding.FragmentFavouriteBinding
import com.example.memorycard.ui.adapters.FavAdapter
import com.example.memorycard.ui.viewmodel.SharedViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavouriteFragment : Fragment() {

    private val viewModelShared: SharedViewModel by activityViewModels()

    private var _binding: FragmentFavouriteBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: FavAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFavouriteBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvFavourite.layoutManager = LinearLayoutManager(context)
        adapter = FavAdapter()
        binding.rvFavourite.adapter = adapter

        viewModelShared.favCard.observe(viewLifecycleOwner) { favourites ->
            adapter.submitList(favourites)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}