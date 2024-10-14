package com.projectx.homework1_5month.network

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.projectx.homework1_5month.api.ApiService
import com.projectx.homework1_5month.models.BaseResponse
import com.projectx.homework1_5month.models.Character
import com.projectx.resource.Resource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class Reprository @Inject constructor(

    private val api: ApiService

) {

    fun fetchCharacters(): LiveData<Resource <List<Character>>> {
        val data = MutableLiveData<Resource <List<Character>>>()
        data.postValue(Resource.Loading())
        api.fetchCharacter().enqueue(object : Callback<List<Character>> {
            override fun onResponse(call: Call<List<Character>>, response: Response<List<Character>>) {
                if (response.isSuccessful && response.body() != null) {
                    data.postValue(Resource.Success(response.body()!!))

                }
            }


            override fun onFailure(call: Call<List<Character>>, t: Throwable) {
                 data.postValue(Resource.Error(t.localizedMessage?:"Unknown Error"))
            }
        })
        return data
    }

}