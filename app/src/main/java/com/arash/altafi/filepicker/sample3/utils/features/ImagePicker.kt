package com.arash.altafi.filepicker.sample3.utils.features

import android.content.Intent
import com.arash.altafi.filepicker.sample2.util.parcelableArrayList
import com.arash.altafi.filepicker.sample3.utils.features.cameraonly.ImagePickerCameraOnly
import com.arash.altafi.filepicker.sample3.utils.model.Image

object ImagePicker {
    fun cameraOnly(): ImagePickerCameraOnly {
        return ImagePickerCameraOnly()
    }

    /* --------------------------------------------------- */
    /* > Helper */
    /* --------------------------------------------------- */

    @Deprecated(
        "This method will marked internal soon. Please use the new API", ReplaceWith(
            "intent?.getParcelableArrayListExtra(IpCons.EXTRA_SELECTED_IMAGES)",
            "com.arash.altafi.filepicker.sample3.imagepicker.features.IpCons"
        )
    )
    fun getImages(intent: Intent?): List<Image>? {
        return intent?.parcelableArrayList(IpCons.EXTRA_SELECTED_IMAGES)
    }
}