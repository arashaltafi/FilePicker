package com.arash.altafi.filepicker.sample3.utils.features.common

import com.arash.altafi.filepicker.sample3.utils.features.ImagePickerSavePath
import com.arash.altafi.filepicker.sample3.utils.features.ReturnMode

abstract class BaseConfig {
    abstract var savePath: ImagePickerSavePath
    abstract var returnMode: ReturnMode
    abstract var isSaveImage: Boolean
}