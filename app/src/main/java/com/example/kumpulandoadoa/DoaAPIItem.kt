package com.example.kumpulandoadoa

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DoaAPIItem(
    val artinya: String,
    val ayat: String,
    val doa: String,
    val id: String,
    val latin: String
) : Parcelable