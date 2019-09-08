package com.chrynan.chat.binder

import com.chrynan.chat.view.View
import com.chrynan.chat.viewmodel.ViewModel

interface Binder<V : View, VM : ViewModel?> {

    val view: V

    suspend fun bind(viewModel: VM)
}