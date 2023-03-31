package com.arash.altafi.filepicker.sample3.utils.features

import android.content.Context
import com.arash.altafi.filepicker.sample3.utils.features.camera.CameraModule
import com.arash.altafi.filepicker.sample3.utils.features.camera.DefaultCameraModule
import com.arash.altafi.filepicker.sample3.utils.features.fileloader.DefaultImageFileLoader
import com.arash.altafi.filepicker.sample3.utils.features.fileloader.ImageFileLoader
import com.arash.altafi.filepicker.sample3.utils.features.imageloader.DefaultImageLoader
import com.arash.altafi.filepicker.sample3.utils.features.imageloader.ImageLoader

interface ImagePickerComponents {
    val appContext: Context
    val imageLoader: ImageLoader
    val imageFileLoader: ImageFileLoader
    val cameraModule: CameraModule
}

open class DefaultImagePickerComponents(context: Context) : ImagePickerComponents {
    override val appContext: Context = context.applicationContext
    override val imageLoader: ImageLoader by lazy { DefaultImageLoader() }
    override val imageFileLoader: ImageFileLoader by lazy { DefaultImageFileLoader(context.applicationContext) }
    override val cameraModule: CameraModule by lazy { DefaultCameraModule() }
}

object ImagePickerComponentsHolder : ImagePickerComponents {

    private lateinit var internalComponents: ImagePickerComponents

    override val appContext: Context
        get() = internalComponents.appContext

    override val imageLoader: ImageLoader
        get() = internalComponents.imageLoader

    override val imageFileLoader: ImageFileLoader
        get() = internalComponents.imageFileLoader

    override val cameraModule: CameraModule
        get() = internalComponents.cameraModule

    fun setInternalComponent(components: ImagePickerComponents) {
        internalComponents = components
    }
}