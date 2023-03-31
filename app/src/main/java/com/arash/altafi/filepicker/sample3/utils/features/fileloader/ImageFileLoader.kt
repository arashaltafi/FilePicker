package com.arash.altafi.filepicker.sample3.utils.features.fileloader

import com.arash.altafi.filepicker.sample3.utils.features.ImagePickerConfig
import com.arash.altafi.filepicker.sample3.utils.features.common.ImageLoaderListener

interface ImageFileLoader {
    fun loadDeviceImages(config: ImagePickerConfig, listener: ImageLoaderListener)
    fun abortLoadImages()
}