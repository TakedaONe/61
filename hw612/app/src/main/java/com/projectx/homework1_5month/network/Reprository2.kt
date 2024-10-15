package com.projectx.homework1_5month.network

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.projectx.homework1_5month.api.ApiService
import com.projectx.homework1_5month.models.Character
import com.projectx.resource.Resource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class Reprository2 @Inject constructor(private val api: ApiService,
                                       private val viewModelScope: CoroutineScope
) {


    fun getCharacterById(id: Int): LiveData<Resource<Character?>> {
        val data = MutableLiveData<Resource<Character?>>()
        data.postValue(Resource.Loading())


        viewModelScope.launch {
            try {
                val character = withContext(Dispatchers.IO) {
                    api.fetchCharacterById(id)
                }

                if (character != null) {

                } else {
                    data.postValue(Resource.Error("Character not found"))
                }
            } catch (t: Throwable) {
                data.postValue(Resource.Error(t.localizedMessage ?: "Unknown Error"))
            }
        }
        return data
    }
}
