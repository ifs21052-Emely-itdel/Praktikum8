package com.ifs21052.pampraktikum8

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ListChat(
    var username: String,
    var propic: Int,
    var message: String,
    var time: String,
) : Parcelable