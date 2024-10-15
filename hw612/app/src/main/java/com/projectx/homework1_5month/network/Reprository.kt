package com.projectx.homework1_5month.network

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.projectx.homework1_5month.api.ApiService
import com.projectx.homework1_5month.models.BaseResponse
import com.projectx.homework1_5month.models.Character
import com.projectx.resource.Resource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class Reprository @Inject constructor(
    private val api: ApiService,
    private val coroutineScope: CoroutineScope
) {

    fun fetchCharacters(): LiveData<Resource<List<Character>>> {
        val data = MutableLiveData<Resource<List<Character>>>()
        data.postValue(Resource.Loading())


        coroutineScope.launch {
            try {
                val response = withContext(Dispatchers.IO) {
                    api.fetchCharacter()
                }

                if (response.isSuccessful && response.body() != null) {
                    data.postValue(Resource.Success(response.body()!!))
                } else {
                    data.postValue(Resource.Error("Error: ${response.code()}"))
                }
            } catch (t: Throwable) {
                data.postValue(Resource.Error(t.localizedMessage ?: "Unknown Error"))
            }
        }
        return data
    }
}
