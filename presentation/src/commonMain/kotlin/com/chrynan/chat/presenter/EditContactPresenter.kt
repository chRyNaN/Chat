package com.chrynan.chat.presenter

import com.chrynan.chat.coroutines.CoroutineDispatchers
import com.chrynan.chat.di.Inject
import com.chrynan.chat.view.EditContactView

class EditContactPresenter @Inject constructor(
    dispatchers: CoroutineDispatchers,
    private val view: EditContactView
) : BasePresenter(dispatchers) {
}