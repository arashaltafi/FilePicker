package com.arash.altafi.filepicker.sample1.utils

import android.content.Intent
import android.provider.ContactsContract
import android.provider.MediaStore

object Picker {

    fun pickImage(): Intent = Intent()
        .setType("image/*")
        .setAction(Intent.ACTION_GET_CONTENT)

    fun pickMovie(): Intent = Intent()
        .setType("video/*")
        .setAction(Intent.ACTION_GET_CONTENT)

    fun pickContact(): Intent = Intent(
        Intent.ACTION_PICK,
        ContactsContract.CommonDataKinds.Phone.CONTENT_URI
    )

    fun pickAudio(): Intent = Intent()
        .setType("audio/*")
        .setAction(Intent.ACTION_GET_CONTENT)

    fun pickCamera(): Intent = Intent(
        MediaStore.ACTION_IMAGE_CAPTURE
    )

    fun pickPdf(): Intent = Intent()
        .setType("application/pdf")
        .setAction(Intent.ACTION_GET_CONTENT)

    fun pickFile(): Intent = Intent()
        .setType("*/*")
        .setAction(Intent.ACTION_GET_CONTENT)

}