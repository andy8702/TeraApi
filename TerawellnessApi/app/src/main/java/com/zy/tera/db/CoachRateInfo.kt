package com.zy.tera.db

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CoachRateInfo(val id:String,val name:String):Parcelable {
    var rate:Int? = null;
}