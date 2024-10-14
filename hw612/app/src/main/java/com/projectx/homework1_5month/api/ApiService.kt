package com.projectx.homework1_5month.api

import com.projectx.homework1_5month.models.BaseResponse
import com.projectx.homework1_5month.models.Character
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("character")
    fun fetchCharacter(): Call<BaseResponse>

    @GET("character/{id}")
    fun fetchCharacterById(@Path("id") id: Int): Call<Character>
}
