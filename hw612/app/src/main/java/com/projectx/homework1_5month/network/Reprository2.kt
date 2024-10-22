package com.projectx.homework1_5month.network

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.projectx.homework1_5month.api.ApiService
import com.projectx.homework1_5month.models.Character
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class Reprository2 (private val api: ApiService):BaseRepository() {

    suspend fun getCharacterById(id: Int): LiveData<Character?> {
        return makeApiCall { api.fetchCharacterById(id)  }
    }


}
