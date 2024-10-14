package com.projectx.homework1_5month.network

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.projectx.homework1_5month.api.ApiService
import com.projectx.homework1_5month.models.BaseResponse
import com.projectx.homework1_5month.models.Character
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class Reprository @Inject constructor(

    private val api: ApiService

) {

    fun fetchCharacters(): LiveData<List<Character>> {
        val data = MutableLiveData<List<Character>>()
        api.fetchCharacter().enqueue(object : Callback<BaseResponse> {
            override fun onResponse(call: Call<BaseResponse>, response: Response<BaseResponse>) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        data.postValue(it.characters)
                    }
                }
            }

            override fun onFailure(call: Call<BaseResponse>, t: Throwable) {

                data.postValue(emptyList())
            }
        })
        return data
    }

}