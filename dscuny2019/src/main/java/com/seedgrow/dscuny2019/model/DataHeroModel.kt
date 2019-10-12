package com.seedgrow.dscuny2019.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DataHeroModel (
    var image: String? = null,
    var name: String? = null,
    var birthday: String? = null,
    var description: String? = null
): Parcelable