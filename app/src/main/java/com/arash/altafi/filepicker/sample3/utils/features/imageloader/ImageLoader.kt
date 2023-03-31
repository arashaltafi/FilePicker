package com.arash.altafi.filepicker.sample3.utils.features.imageloader

import android.widget.ImageView
import com.arash.altafi.filepicker.sample3.utils.model.Image

interface ImageLoader {
    fun loadImage(image: Image, imageView: ImageView, imageType: ImageType)
}