package com.chrynan.chat.adapter

interface DiffResult<VM : AdapterItem> {

    val items: List<VM>
}