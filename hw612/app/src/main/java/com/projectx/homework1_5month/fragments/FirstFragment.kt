package com.projectx.homework1_5month.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.projectx.homework1_5month.databinding.FragmentFirstBinding
import com.projectx.homework1_5month.adapter.AppAdapter
import com.projectx.homework1_5month.adapter.CharacterListAdapter
import com.projectx.homework1_5month.viewModel.FragmentViewModel
import com.projectx.resource.Resource
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class FirstFragment : Fragment() {

    private val charactersAdapter by lazy {
        CharacterListAdapter()
    }
    private val viewModel by lazy {
        ViewModelProvider(this)[FragmentViewModel::class.java]
    }
    private val binding by lazy {
        FragmentFirstBinding.inflate(layoutInflater)
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }

    @SuppressLint("FragmentLiveDataObserve")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRecyclerView()

        viewModel.fetchCharacters().observe(this) { res ->
            binding.progresBar.isVisible = res is Resource.Loading
            when (res) {
                is Resource.Error -> {
                    Toast.makeText(requireContext(), res.message, Toast.LENGTH_SHORT).show()
                }
                is Resource.Success -> {
                    charactersAdapter.submitList(res.data)
                }

                else -> {}
            }
        }
    }

    private fun setUpRecyclerView()= with(binding.rvApp) {
     adapter = charactersAdapter
        layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
    }
}

