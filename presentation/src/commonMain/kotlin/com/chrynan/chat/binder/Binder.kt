package com.chrynan.chat.binder

import com.chrynan.chat.viewmodel.ViewModel

interface Binder<VM : ViewModel> {

    suspend fun bind(viewModel: VM)
}