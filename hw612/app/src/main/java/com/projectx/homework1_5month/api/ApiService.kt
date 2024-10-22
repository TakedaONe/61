package com.projectx.homework1_5month.api

import com.projectx.homework1_5month.models.BaseResponse
import com.projectx.homework1_5month.models.Character
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("character")
    suspend fun fetchCharacter(): Response<BaseResponse>

    @GET("character/{id}")
    suspend fun fetchCharacterById(@Path("id") id: Int): Response<Character>
}
