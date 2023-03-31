package com.arash.altafi.filepicker.sample3.utils.features.camera

import android.content.Context
import android.content.Intent
import com.arash.altafi.filepicker.sample3.utils.features.common.BaseConfig
import com.arash.altafi.filepicker.sample3.utils.model.Image

typealias OnImageReadyListener = (List<Image>?) -> Unit

interface CameraModule {
    fun getCameraIntent(context: Context, config: BaseConfig): Intent?
    fun getImage(context: Context, intent: Intent?, imageReadyListener: OnImageReadyListener)
    fun removeImage(context: Context)
}