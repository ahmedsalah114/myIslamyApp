package com.example.islamyapp.ui.home.tabs.hadeath

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class HadeathItem(
    val name:String?=null,
    val hadeathContent:String?=null
):Parcelable
