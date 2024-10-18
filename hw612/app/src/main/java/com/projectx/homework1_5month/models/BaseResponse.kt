package com.projectx.homework1_5month.models



import com.google.gson.annotations.SerializedName


data class BaseResponse(
    @SerializedName("info")
    val info: Info,
    @SerializedName("results")
    val characters: List<Character>
)