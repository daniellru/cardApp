package com.example.memorycard.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.memorycard.R
import com.example.memorycard.data.model.CardData
import com.example.memorycard.databinding.FragmentAddBinding
import com.example.memorycard.ui.viewmodel.AddViewModel
import com.example.memorycard.ui.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddFragment : Fragment() {

    private val addViewModel: AddViewModel by viewModels()

    private var _binding: FragmentAddBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnConfirm.setOnClickListener {
            if(binding.edtFrontWord.text.isNotEmpty() && binding.edtBackWord.text.isNotEmpty()){
                addViewModel.addNewCard(
                    binding.edtFrontWord.text.toString(),
                    binding.edtBackWord.text.toString())
                HomeViewModel.currentIndex = 0
                refreshUi()
            }else{
                Toast.makeText(context, "Please fill in all the fields", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun refreshUi() {
        binding.edtFrontWord.setText("")
        binding.edtBackWord.setText("")
        Toast.makeText(context,"Card Added", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}