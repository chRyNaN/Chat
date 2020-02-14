package com.chrynan.chat.feature.conversation.widget

import android.content.Context
import android.os.Build
import android.util.AttributeSet
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputConnection
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.view.inputmethod.EditorInfoCompat
import androidx.core.view.inputmethod.InputConnectionCompat
import androidx.core.view.inputmethod.InputContentInfoCompat
import com.chrynan.chat.R

class MessageEditText @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = R.attr.editTextStyle
) : AppCompatEditText(context, attrs, defStyleAttr) {

    var supportedMediaTypes: List<MediaType> = listOf(
        MediaType.IMAGE
    )

    var listener: MediaItemSelectedListener? = null

    override fun onCreateInputConnection(editorInfo: EditorInfo): InputConnection {
        val inputConnection: InputConnection = super.onCreateInputConnection(editorInfo)
        EditorInfoCompat.setContentMimeTypes(editorInfo, supportedMediaTypes.allMimeTypes())

        val callback =
            InputConnectionCompat.OnCommitContentListener { inputContentInfo, flags, _ ->
                val lacksPermission =
                    (flags and InputConnectionCompat.INPUT_CONTENT_GRANT_READ_URI_PERMISSION) != 0

                // read and display inputContentInfo asynchronously
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N_MR1 && lacksPermission) {
                    try {
                        inputContentInfo.requestPermission()
                    } catch (e: Exception) {
                        return@OnCommitContentListener false // return false if failed
                    }
                }

                // read and display inputContentInfo asynchronously.
                // call inputContentInfo.releasePermission() as needed.
                listener?.onMediaItemSelected(contentInfo = inputContentInfo)
                // TODO release permission safely when the listener is finished (issue with async?)
                // inputContentInfo.releasePermission()

                true  // return true if succeeded
            }

        return InputConnectionCompat.createWrapper(inputConnection, editorInfo, callback)
    }

    private fun List<MediaType>.allMimeTypes(): Array<String> {
        val list = mutableListOf<String>()

        forEach {
            list.addAll(it.mimeTypes)
        }

        return list.toTypedArray()
    }

    enum class MediaType(val mimeTypes: List<String>) {
        IMAGE(mimeTypes = listOf("images/*")),
        AUDIO(mimeTypes = listOf("audio/*")),
        VIDEO(mimeTypes = listOf("video/*")),
        FILE(mimeTypes = listOf("*/*"));

        companion object {

            fun fromMimeType(mimeType: String): MediaType? =
                MediaType.values().firstOrNull { it.mimeTypes.contains(mimeType) }
        }
    }

    interface MediaItemSelectedListener {

        fun onMediaItemSelected(contentInfo: InputContentInfoCompat)
    }
}