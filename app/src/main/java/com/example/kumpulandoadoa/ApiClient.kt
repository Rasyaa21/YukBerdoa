package com.example.kumpulandoadoa

import retrofit2.Retrofit
import retrofit2.Retrofit.Builder
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    private const val BaseURl = "https://doa-doa-api-ahmadramadhan.fly.dev/"

    val instance : doaInterface by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BaseURl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(doaInterface::class.java)

    }
}