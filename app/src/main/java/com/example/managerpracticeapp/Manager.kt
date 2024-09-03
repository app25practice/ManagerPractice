package com.example.managerpracticeapp

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Manager(
     val name : String,
     var reviewCount : Int,
     var rating : Double,

) : Parcelable