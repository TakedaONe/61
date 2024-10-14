package com.projectx.homework1_5month.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.projectx.homework1_5month.models.Character
import com.projectx.homework1_5month.network.Reprository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FragmentViewModel @Inject constructor (
    private val reprository: Reprository
) :ViewModel() {

    val characters: LiveData<List<Character>> = reprository.fetchCharacters()
}