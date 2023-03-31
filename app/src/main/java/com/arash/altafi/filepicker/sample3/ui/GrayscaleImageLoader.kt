package com.arash.altafi.filepicker.sample3.ui

import android.widget.ImageView
import com.arash.altafi.filepicker.sample3.utils.features.imageloader.ImageLoader
import com.arash.altafi.filepicker.sample3.utils.features.imageloader.ImageType
import com.arash.altafi.filepicker.sample3.utils.model.Image
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.BitmapTransitionOptions
import com.bumptech.glide.request.RequestOptions

class GrayscaleImageLoader : ImageLoader {
    override fun loadImage(image: Image, imageView: ImageView, imageType: ImageType) {
        Glide.with(imageView)
            .asBitmap()
            .load(image.path)
            .transition(BitmapTransitionOptions.withCrossFade())
            .apply(REQUEST_OPTIONS)
            .into(imageView)
    }

    companion object {
        private val REQUEST_OPTIONS = RequestOptions().transform(GrayscaleTransformation())
    }
}