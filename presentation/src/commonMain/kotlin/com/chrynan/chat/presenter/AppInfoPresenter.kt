package com.chrynan.chat.presenter

import com.chrynan.chat.binder.AppInfoBinder
import com.chrynan.chat.coroutines.CoroutineDispatchers
import com.chrynan.chat.di.Inject
import com.chrynan.chat.resources.Colors
import com.chrynan.chat.resources.Strings
import com.chrynan.chat.viewmodel.AppInfoViewModel
import kotlinx.coroutines.launch

class AppInfoPresenter @Inject constructor(
    dispatchers: CoroutineDispatchers,
    private val colors: Colors,
    private val strings: Strings,
    private val binder: AppInfoBinder
) : BasePresenter(dispatchers = dispatchers) {

    fun getInfo() {
        val model = AppInfoViewModel(
            versionLabel = strings.appInfoVersionLabel,
            version = "0.1.0",
            versionCodeLabel = strings.appInfoVersionCodeLabel,
            versionCode = "1",
            updateAvailableLabel = strings.appInfoUpdateAvailableLabel,
            updateAvailableDescription = "All up to date",
            updateAvailableDescriptionColorInt = colors.accentTwo,
            licenseLabel = strings.appInfoLicenseLabel,
            licenseName = "Apache 2.0",
            licenseUri = "https://github.com/chRyNaN/Chat/blob/master/LICENSE",
            sourceCodeLabel = strings.appInfoSourceCodeLabel,
            sourceCodeTitle = strings.appInfoSourceCodeTitle,
            sourceCodeUri = "https://github.com/chRyNaN/Chat",
            appStoreIDLabel = strings.appInfoAppStoreIDLabel,
            appStoreID = "com.chrynan.chat"
        )

        launch {
            binder.bind(model)
        }
    }
}