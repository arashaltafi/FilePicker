package com.arash.altafi.filepicker.sample1

import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.database.Cursor
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import com.arash.altafi.filepicker.databinding.ActivitySample1Binding
import com.arash.altafi.filepicker.sample1.utils.PermissionUtils
import com.arash.altafi.filepicker.sample1.utils.Picker
import com.arash.altafi.filepicker.sample1.utils.UriUtils
import java.util.*

class SampleActivity1 : AppCompatActivity() {

    private val binding by lazy {
        ActivitySample1Binding.inflate(layoutInflater)
    }

    private val resultLauncherImage = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        getUriFromActivityResult(result)
    }

    private val resultLauncherMovie = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        getUriFromActivityResult(result)
    }

    private val registerResultCamera =
        PermissionUtils.register(this, object : PermissionUtils.PermissionListener {
            override fun observe(permissions: Map<String, Boolean>) {
                if (permissions[Manifest.permission.CAMERA] == true) {
                    resultLauncherCamera.launch(Picker.pickCamera())
                }
            }
        })

    private val resultLauncherCamera = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        getUriFromActivityResult(result)
    }

    @SuppressLint("Range")
    private val resultLauncherPdf = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        getUriFromActivityResult(result)
    }

    @SuppressLint("Range")
    private val resultLauncherAudio = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        getUriFromActivityResult(result)
    }

    @SuppressLint("Range")
    private val resultLauncherFile = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        getUriFromActivityResult(result)
    }

    private val resultLauncherContact = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        getContactFromActivityResult(result)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        init()
    }

    private fun init() = binding.apply {
        btnCamera.setOnClickListener {
            if (!PermissionUtils.isGranted(this@SampleActivity1, Manifest.permission.CAMERA)) {
                PermissionUtils.requestPermission(
                    this@SampleActivity1,
                    registerResultCamera,
                    Manifest.permission.CAMERA
                )
            } else {
                resultLauncherCamera.launch(Picker.pickCamera())
            }
        }

        btnImage.setOnClickListener {
            resultLauncherImage.launch(Picker.pickImage())
        }

        btnMovie.setOnClickListener {
            resultLauncherMovie.launch(Picker.pickMovie())
        }

        btnAudio.setOnClickListener {
            resultLauncherAudio.launch(Picker.pickAudio())
        }

        btnContact.setOnClickListener {
            resultLauncherContact.launch(Picker.pickContact())
        }

        btnPdf.setOnClickListener {
            resultLauncherPdf.launch(Picker.pickPdf())
        }

        btnFile.setOnClickListener {
            resultLauncherFile.launch(Picker.pickFile())
        }
    }

    private fun getUriFromActivityResult(result: ActivityResult) {
        if (result.resultCode == Activity.RESULT_OK) {
            val data: Intent? = result.data
            val uri: Uri? = data?.data
            try {
                uri?.let {
                    val uriPath = UriUtils.getPathFromUri(this, it)
                    uriPath?.let { path ->
//                        binding.iv.setImageURI(File(path).toUri())
                        Log.i("test123321", "Path Uri: $path")
                        binding.tvPath.text = path
                    }
                    binding.tvUri.text = it.toString()
                    binding.iv.setImageURI(it)
                    Log.i("test123321", "uri: $it")
                }
            } catch (e: Exception) {
                Toast.makeText(this, e.message, Toast.LENGTH_SHORT).show()
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private fun getContactFromActivityResult(result: ActivityResult) {
        if (result.resultCode == Activity.RESULT_OK) {
            val data: Intent? = result.data
            val uri: Uri? = data?.data
            var cursor: Cursor? = null
            try {
                val phoneNo: String?
                val name: String?
                uri?.let {
                    cursor = contentResolver.query(uri, null, null, null, null)
                }
                cursor?.moveToFirst()
                val phoneIndex: Int? =
                    cursor?.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER)
                val nameIndex: Int? =
                    cursor?.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME)
                phoneIndex?.let {
                    nameIndex?.let {
                        phoneNo = cursor?.getString(phoneIndex)
                        name = cursor?.getString(nameIndex)
                        Log.i("test123321", "name: $name, phone: $phoneNo")
                        binding.tvUri.text = "name: $name, phone: $phoneNo"
                        uri?.let {
                            val uriPath = UriUtils.getPathFromUri(this, it)
                            uriPath?.let { path ->
                                Log.i("test123321", "Path Contact: $path")
                                binding.tvPath.text = path
                            }
                        }
                    }
                }
            } catch (e: Exception) {
                cursor?.close()
                Toast.makeText(this, e.message, Toast.LENGTH_SHORT).show()
            }
        }
    }

}