package com.packagesayur.yursayur.data.sayurdata

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

data class SayurEntity(
    var id : Int = 0,
    var gambar: Int = 0,
    var nama: String = "",
    var rate: Double = 0.0,
    var people: Int = 0,
    var harga: Int = 0,
    var deskripsi: String = "",
    var gambartoko: Int = 0,
    var toko: String = "",
    var lokasi: String = "",
    var statuses : String = "",
)