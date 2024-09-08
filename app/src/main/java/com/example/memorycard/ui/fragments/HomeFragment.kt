package com.example.memorycard.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.memorycard.R
import com.example.memorycard.databinding.FragmentHomeBinding
import com.example.memorycard.ui.viewmodel.HomeViewModel
import com.example.memorycard.ui.viewmodel.SharedViewModel
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private val viewModelHome: HomeViewModel by activityViewModels()

    private val viewModelShared: SharedViewModel by viewModels()

    private var _binding : FragmentHomeBinding? = null
    val binding: FragmentHomeBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModelHome.cardList.observe(viewLifecycleOwner){ cardDataList ->
            if(!viewModelHome.isCardListEmpty()){
                var currentCard = viewModelHome.cardList.value?.first()
                binding.tvMainWord.text = currentCard?.frontText
            }
        }

        binding.imgFav.setOnClickListener{
            viewModelShared.onFavClicked(viewModelHome.getCurrentCard()!!)
        }

        binding.imgCheck.setOnClickListener{
            viewModelHome.onItemClick()

            val currentCard = viewModelHome.getCurrentCard()
            binding.tvMainWord.text = currentCard?.frontText
        }

        binding.imgEdit.setOnClickListener{
            navigateToEditFrag()
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun navigateToEditFrag() {
        val action = viewModelHome.getCurrentCard()?.let { card ->
            HomeFragmentDirections.actionHomeFragmentToEditFragment(card)
        }
        if (action != null) {
            findNavController().navigate(action)
        }
    }
}