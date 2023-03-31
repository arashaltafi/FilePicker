package com.arash.altafi.filepicker.sample2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.arash.altafi.filepicker.databinding.ActivitySample2Binding
import com.arash.altafi.filepicker.sample2.util.ProPicker
import com.bumptech.glide.Glide

class SampleActivity2 : AppCompatActivity() {

    private val binding by lazy {
        ActivitySample2Binding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        init()
    }

    private fun init() = binding.apply {
        btnChooser.setOnClickListener {
            ProPicker
                .with(this@SampleActivity2)
//                .compressImage()
//                .cameraOnly()
                .start { resultCode, data ->
                    if (resultCode == RESULT_OK && data != null) {
                        iv.setImageURI(ProPicker.getPickerData(data)?.uri)
                    }
                }
        }

        btnGallery.setOnClickListener {
            ProPicker.with(this@SampleActivity2)
                .galleryOnly()
                .compressImage()
                .start { resultCode, data ->
                    if (resultCode == RESULT_OK && data != null) {
                        val list = ProPicker.getSelectedPickerDatas(data)
                        if (list.size > 0) {
                            Glide.with(this@SampleActivity2)
                                .load(list[0].file)
                                .into(iv)
                        }

                    }
                }
        }

        btnShowCameraOnlyWithCrop.setOnClickListener {
            ProPicker.with(this@SampleActivity2)
                .cameraOnly()
                .crop()
                .start { resultCode, data ->
                    if (resultCode == RESULT_OK && data != null) {
                        iv.setImageURI(ProPicker.getPickerData(data)?.uri)
                    }
                }
        }

        btnShowCameraOnlyCompress.setOnClickListener {
            ProPicker.with(this@SampleActivity2)
                .cameraOnly()
                .compressImage()
                .start { resultCode, data ->
                    if (resultCode == RESULT_OK && data != null) {
                        iv.setImageURI(ProPicker.getPickerData(data)?.uri)
                    }
                }
        }
    }
}