package com.projectx.homework1_5month.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.projectx.homework1_5month.models.Character
import com.projectx.homework1_5month.network.Reprository2
import com.projectx.resource.Resource
import kotlinx.coroutines.launch
import javax.inject.Inject



class SecondViewModel @Inject constructor(private val repository2: Reprository2) : ViewModel() {

   fun getCharacters() = repository2.getCharacterById(0)
}


