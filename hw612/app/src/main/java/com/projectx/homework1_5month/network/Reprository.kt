package com.projectx.homework1_5month.network

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.projectx.homework1_5month.api.ApiService
import com.projectx.homework1_5month.models.Character

class Reprository(private val api: ApiService) : BaseRepository() {

    suspend fun fetchCharacters(): LiveData<List<Character>?> = MutableLiveData<List<Character>?>().also {
        it.postValue(makeApiCall { api.fetchCharacter() }.value?.characters)
    }
}
