package com.arash.altafi.filepicker.sample3.utils.features.cameraonly

import android.os.Parcelable
import com.arash.altafi.filepicker.sample3.utils.features.ImagePickerSavePath
import com.arash.altafi.filepicker.sample3.utils.features.ReturnMode
import com.arash.altafi.filepicker.sample3.utils.features.common.BaseConfig
import kotlinx.parcelize.Parcelize

@Parcelize
class CameraOnlyConfig(
    override var savePath: ImagePickerSavePath = ImagePickerSavePath.DEFAULT,
    override var returnMode: ReturnMode = ReturnMode.ALL,
    override var isSaveImage: Boolean = true
) : BaseConfig(), Parcelable