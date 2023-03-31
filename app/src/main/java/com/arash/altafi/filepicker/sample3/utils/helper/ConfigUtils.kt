package com.arash.altafi.filepicker.sample3.utils.helper

import android.content.Context
import com.arash.altafi.filepicker.sample3.utils.features.ImagePickerConfig
import com.arash.altafi.filepicker.sample3.utils.features.ImagePickerMode
import com.arash.altafi.filepicker.sample3.utils.features.ReturnMode
import com.arash.altafi.filepicker.sample3.utils.features.cameraonly.CameraOnlyConfig
import com.arash.altafi.filepicker.sample3.utils.features.common.BaseConfig

object ConfigUtils {
    fun checkConfig(config: ImagePickerConfig): ImagePickerConfig {
        check(
            !(config.mode != ImagePickerMode.SINGLE
                    && (config.returnMode === ReturnMode.GALLERY_ONLY
                    || config.returnMode === ReturnMode.ALL))
        ) { "ReturnMode.GALLERY_ONLY and ReturnMode.ALL is only applicable in Single Mode!" }
        return config
    }

    fun shouldReturn(config: BaseConfig, isCamera: Boolean): Boolean {
        if (config is CameraOnlyConfig) return true
        val mode = config.returnMode
        return if (isCamera) {
            mode === ReturnMode.ALL || mode === ReturnMode.CAMERA_ONLY
        } else {
            mode === ReturnMode.ALL || mode === ReturnMode.GALLERY_ONLY
        }
    }

    fun getFolderTitle(context: Context, config: ImagePickerConfig): String {
        val folderTitle = config.folderTitle
        return if (folderTitle.isNullOrBlank()) "Folder" else folderTitle
    }

    fun getImageTitle(context: Context, config: ImagePickerConfig): String {
        val configImageTitle = config.imageTitle
        return if (configImageTitle.isNullOrBlank()) "Tap to select images" else configImageTitle
    }

    fun getDoneButtonText(context: Context, config: ImagePickerConfig): String {
        val doneButtonText = config.doneButtonText
        return if (doneButtonText.isNullOrBlank()) "DONE" else doneButtonText
    }
}