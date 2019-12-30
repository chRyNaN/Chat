package com.chrynan.chat.ui.adapter.processing

import androidx.recyclerview.widget.DiffUtil
import com.chrynan.chat.adapter.AdapterItem
import com.chrynan.chat.adapter.DiffResult

data class AndroidDiffResult<VM : AdapterItem>(
    override val items: List<VM>,
    val diffUtilResult: DiffUtil.DiffResult
) : DiffResult<VM>