package com.arash.altafi.filepicker.sample3.utils.helper

internal object IpCrasher {
    @JvmStatic
    fun openIssue(): Nothing {
        throw IllegalStateException("This should not happen. Please open an issue!")
    }
}