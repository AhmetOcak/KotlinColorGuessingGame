package com.kotlincolorguessinggame.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kotlincolorguessinggame.databinding.FragmentGameBinding
import com.kotlincolorguessinggame.viewmodel.GameViewModel
import com.kotlincolorguessinggame.viewmodel.GameViewModelFactory

class GameFragment : Fragment() {

    private lateinit var binding: FragmentGameBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGameBinding.inflate(LayoutInflater.from(context))
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.viewModel =
            GameViewModelFactory(requireActivity().application).create(GameViewModel::class.java)
    }
}