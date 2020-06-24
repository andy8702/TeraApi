package com.zy.tera.db

import android.annotation.SuppressLint
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
@SuppressLint("ParcelCreator")// 用于处理 Lint 的错误提示
@Parcelize
data class CoachRateInfo(val id:String,val name:String):Parcelable {
    var rate:Int? = null;
}