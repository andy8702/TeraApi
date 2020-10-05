package com.zy.tera.db

import android.annotation.SuppressLint
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize


@SuppressLint("ParcelCreator")// 用于处理 Lint 的错误提示
@Parcelize
@Entity(tableName = "coachrateinfo")
data class CoachRateInfo(
        @PrimaryKey
        @ColumnInfo(name = "id")
        val id:String,
        @ColumnInfo(name = "name")
        val name:String):Parcelable {

    @ColumnInfo(name = "rate")
    var rate:Float? = null;
}