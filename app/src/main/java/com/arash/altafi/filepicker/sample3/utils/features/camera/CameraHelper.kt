package com.arash.altafi.filepicker.sample3.utils.features.camera

import android.content.Context
import android.content.Intent
import android.provider.MediaStore
import android.widget.Toast

object CameraHelper {
    fun checkCameraAvailability(context: Context): Boolean {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        val isAvailable = intent.resolveActivity(context.packageManager) != null
        if (!isAvailable) {
            val appContext = context.applicationContext
            Toast.makeText(
                appContext,
                "No camera found", Toast.LENGTH_LONG
            ).show()
        }
        return isAvailable
    }
}