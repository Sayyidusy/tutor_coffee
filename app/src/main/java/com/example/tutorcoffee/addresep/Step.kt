package com.example.tutorcoffee.addresep

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Step(
    var icon: Int?,
    var nama: String?,
    var isNeedTimer: Boolean? = false,
    var timer: Int? = 0,
): Parcelable
