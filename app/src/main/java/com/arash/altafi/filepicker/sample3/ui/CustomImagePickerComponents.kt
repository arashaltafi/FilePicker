package com.arash.altafi.filepicker.sample3.ui

import android.content.Context
import com.arash.altafi.filepicker.sample3.utils.features.DefaultImagePickerComponents
import com.arash.altafi.filepicker.sample3.utils.features.imageloader.DefaultImageLoader
import com.arash.altafi.filepicker.sample3.utils.features.imageloader.ImageLoader

class CustomImagePickerComponents(
    context: Context,
    private val useCustomImageLoader: Boolean
) : DefaultImagePickerComponents(context.applicationContext) {
    override val imageLoader: ImageLoader
        get() = if (useCustomImageLoader) {
            GrayscaleImageLoader()
        } else {
            DefaultImageLoader()
        }
}