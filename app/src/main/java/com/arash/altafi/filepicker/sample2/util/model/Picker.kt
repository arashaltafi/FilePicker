package com.arash.altafi.filepicker.sample2.util.model

import android.net.Uri
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.io.File

@Parcelize
data class Picker(val name: String, val uri: Uri, val file: File) : Parcelable