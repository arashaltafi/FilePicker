package com.arash.altafi.filepicker.sample3.utils.listeners

import com.arash.altafi.filepicker.sample3.utils.model.Folder
import com.arash.altafi.filepicker.sample3.utils.model.Image

typealias OnImageClickListener = (Boolean) -> Boolean
typealias OnFolderClickListener = (Folder) -> Unit
typealias OnImageSelectedListener = (List<Image>) -> Unit
