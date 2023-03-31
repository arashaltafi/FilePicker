package com.arash.altafi.filepicker.sample3.utils.features.common

import com.arash.altafi.filepicker.sample3.utils.model.Folder
import com.arash.altafi.filepicker.sample3.utils.model.Image

interface ImageLoaderListener {
    fun onImageLoaded(images: List<Image>, folders: List<Folder>)
    fun onFailed(throwable: Throwable)
}