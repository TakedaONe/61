package com.projectx.homework1_5month.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.projectx.homework1_5month.databinding.FragmentFirstBinding
import com.projectx.homework1_5month.adapter.AppAdapter
import com.projectx.homework1_5month.viewModel.FragmentViewModel
import dagger.hilt.android.AndroidEntryPoint
import org.koin.androidx.viewmodel.ext.android.viewModel


class FirstFragment : Fragment() {

    private lateinit var appAdapter: AppAdapter
    private val viewModel: FragmentViewModel by viewModel()
    private val binding by lazy {
        FragmentFirstBinding.inflate(layoutInflater)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view,savedInstanceState)

        val recyclerView = binding.rvApp




        appAdapter = AppAdapter(emptyList()) { character ->
            val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment(character)
            findNavController().navigate(action)
        }



        recyclerView.adapter = appAdapter

        viewModel.characters.observe(viewLifecycleOwner, { characters ->
            appAdapter.updateData(characters)
        })
    }
}

