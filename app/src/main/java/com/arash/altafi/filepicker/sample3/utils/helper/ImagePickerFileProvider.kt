package com.arash.altafi.filepicker.sample3.utils.helper

import androidx.core.content.FileProvider
import com.arash.altafi.filepicker.sample3.utils.features.DefaultImagePickerComponents
import com.arash.altafi.filepicker.sample3.utils.features.ImagePickerComponentsHolder

class ImagePickerFileProvider : FileProvider() {
    override fun onCreate(): Boolean {
        ImagePickerComponentsHolder.setInternalComponent(DefaultImagePickerComponents(context!!))
        return super.onCreate()
    }
}