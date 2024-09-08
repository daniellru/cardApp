package com.example.memorycard.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.memorycard.R
import com.example.memorycard.data.model.CardData
import com.example.memorycard.databinding.FragmentEditBinding
import com.example.memorycard.ui.viewmodel.EditViewModel
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class EditFragment : Fragment() {

    private var _binding: FragmentEditBinding? = null
    private val binding get() = _binding!!

    private val viewModelEdit: EditViewModel by viewModels()

    private val args: EditFragmentArgs by navArgs()

    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEditBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val card = args.CardData

        navController = findNavController()

        setEditUi(card)

        binding.btnUpdate.setOnClickListener{
            onUpDateClick(card)
        }

        binding.btnDelete.setOnClickListener {
            onDeleteClick(card)
        }
    }

    private fun onDeleteClick(card: CardData) {
        if(card != null){
            viewModelEdit.onDeleteClick(card)
            Toast.makeText(context, "Card Deleted", Toast.LENGTH_SHORT).show()
            navController.popBackStack()
        }

    }

    private fun onUpDateClick(card: CardData) {
        val frontWord = binding.edtFrontWord.text.toString()
        val backWord = binding.edtBackWord.text.toString()

        if(frontWord.isNotEmpty() && backWord.isNotEmpty()){
            val updatedCard = card.copy(
                frontText = frontWord,
                backText = backWord
            )
            viewModelEdit.onUpdateClick(updatedCard)
            navController.popBackStack()
        }else{
            Toast.makeText(context, "Please fill in all the fields", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setEditUi(card: CardData) {
        binding.edtFrontWord.setText(card.frontText)
        binding.edtBackWord.setText(card.backText)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}