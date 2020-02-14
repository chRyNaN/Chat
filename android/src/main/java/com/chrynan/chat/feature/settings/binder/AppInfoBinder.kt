package com.chrynan.chat.feature.settings.binder

import com.chrynan.chat.binder.Binder
import com.chrynan.chat.feature.settings.view.AppInfoView
import com.chrynan.chat.feature.settings.viewmodel.AppInfoViewModel
import javax.inject.Inject

class AppInfoBinder @Inject constructor(override val view: AppInfoView) :
    Binder<AppInfoView, AppInfoViewModel> {

    override suspend fun bind(viewModel: AppInfoViewModel) {
        view.showVersion(label = viewModel.versionLabel, version = viewModel.version)
        view.showVersionCode(
            label = viewModel.versionCodeLabel,
            versionCode = viewModel.versionCode
        )
        view.showAppStoreID(label = viewModel.appStoreIDLabel, id = viewModel.appStoreID)
        view.showLicense(label = viewModel.licenseLabel, licenseName = viewModel.licenseName)
        view.showSourceCode(label = viewModel.sourceCodeLabel, title = viewModel.sourceCodeTitle)

        if (viewModel.updateAvailableDescription != null) {
            view.showUpdateAvailable(
                label = viewModel.updateAvailableLabel,
                updateDescription = viewModel.updateAvailableDescription,
                descriptionColorInt = viewModel.updateAvailableDescriptionColorInt
            )
        } else {
            view.hideUpdateAvailable()
        }
    }
}