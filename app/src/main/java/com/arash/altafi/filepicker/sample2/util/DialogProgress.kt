package com.arash.altafi.filepicker.sample2.util

import android.app.Dialog
import android.content.Context
import android.view.LayoutInflater
import com.arash.altafi.filepicker.databinding.DialogProgressBinding

object DialogProgress {

    fun showProgressDialog(
        context: Context,
        msg: String,
        isCancelable: Boolean = false
    ): Dialog {

        val binding = DialogProgressBinding.inflate(LayoutInflater.from(context))

        val d = Dialog(context)
        d.setContentView(binding.root)
        d.setCancelable(isCancelable)

        binding.tvMsg.text = msg

        return d
    }

}