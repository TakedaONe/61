package com.projectx.homework1_5month.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.projectx.homework1_5month.R
import com.projectx.homework1_5month.databinding.FragmentSecondBinding
import com.projectx.homework1_5month.models.Character
import com.projectx.homework1_5month.viewModel.SecondViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class SecondFragment : Fragment() {

    private val secondViewModel: SecondViewModel by viewModel()
    private val binding by lazy { FragmentSecondBinding.inflate(layoutInflater) }
    private var characterId: Int? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        characterId = arguments?.getInt("characterId")
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        characterId?.let { id ->

            secondViewModel.getCharacterById(id).observe(viewLifecycleOwner, Observer { character ->
                character?.let {
                    displayCharacterInfo(it)
                }
            })
        }
    }

    private fun displayCharacterInfo(character: Character) {
        binding.characterName.text = character.name
        binding.characterStatus.text = character.status
        binding.characterGender.text = "Gender: ${character.gender}"
        binding.characterLocation.text = "Last known location: ${character.location.name}"
        binding.characterFirstSeen.text = "First seen in: ${character.episode.joinToString()}"

        Glide.with(this)
            .load(character.image)
            .placeholder(R.drawable.placeholder_image)
            .into(binding.characterImage)
    }
}
