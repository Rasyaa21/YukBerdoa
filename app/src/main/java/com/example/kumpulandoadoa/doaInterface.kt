package com.example.kumpulandoadoa

import retrofit2.http.GET
import retrofit2.Call

interface doaInterface {
    @GET("api")
    fun GetPosts() : Call<ArrayList<DoaAPIItem>>
}