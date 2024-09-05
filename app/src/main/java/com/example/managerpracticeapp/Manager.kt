package com.example.managerpracticeapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Manager(
    val name: String,
) : Parcelable
