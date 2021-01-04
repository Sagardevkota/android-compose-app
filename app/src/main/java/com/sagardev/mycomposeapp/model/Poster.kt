package com.sagardev.mycomposeapp.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Poster(
        val id: Long,
        val name: String,
        val release: String,
        val playtime: String,
        val description: String,
        val plot: String,
        val poster: String
) : Parcelable