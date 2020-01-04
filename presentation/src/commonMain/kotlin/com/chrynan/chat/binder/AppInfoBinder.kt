package com.chrynan.chat.binder

import com.chrynan.chat.di.Inject
import com.chrynan.chat.view.AppInfoView
import com.chrynan.chat.viewmodel.AppInfoViewModel

class AppInfoBinder @Inject constructor(override val view: AppInfoView) : Binder<AppInfoView, AppInfoViewModel> {

    override suspend fun bind(viewModel: AppInfoViewModel) {
        view.showVersion(label = viewModel.versionLabel, version = viewModel.version)
        view.showVersionCode(label = viewModel.versionCodeLabel, versionCode = viewModel.versionCode)
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