package com.example.netflix.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie(
    val poster_path: String? = null,
    val overview: String? = null,
    val released_date: String? = null,
    val id: Int? = null,
    val original_title: String? = null,
    val vote_count: Int? = 0,
    val vote_average: Float? = null
) : Parcelable