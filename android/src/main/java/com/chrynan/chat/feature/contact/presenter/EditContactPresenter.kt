package com.chrynan.chat.feature.contact.presenter

import com.chrynan.chat.coroutines.CoroutineDispatchers
import com.chrynan.chat.feature.contact.view.EditContactView
import com.chrynan.chat.presenter.BasePresenter
import javax.inject.Inject

class EditContactPresenter @Inject constructor(
    dispatchers: CoroutineDispatchers,
    private val view: EditContactView
) : BasePresenter(dispatchers) {
}