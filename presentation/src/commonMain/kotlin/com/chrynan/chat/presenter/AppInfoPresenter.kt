package com.chrynan.chat.presenter

import com.chrynan.chat.binder.AppInfoBinder
import com.chrynan.chat.coroutines.CoroutineDispatchers
import com.chrynan.chat.viewmodel.AppInfoViewModel
import kotlinx.coroutines.launch

class AppInfoPresenter(
    dispatchers: CoroutineDispatchers,
    private val binder: AppInfoBinder
) : Presenter(dispatchers = dispatchers) {

    fun getInfo() {
        val model = AppInfoViewModel(
            version = "1.0.0",
            updateDescription = "All up to date",
            isUpToDate = true
        )

        launch {
            binder.bind(model)
        }
    }
}