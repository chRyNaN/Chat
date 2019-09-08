package com.chrynan.chat.binder

import com.chrynan.chat.view.AppInfoView
import com.chrynan.chat.viewmodel.AppInfoViewModel

class AppInfoBinder(override val view: AppInfoView) : Binder<AppInfoView, AppInfoViewModel?> {

    override suspend fun bind(viewModel: AppInfoViewModel?) {
        if (viewModel == null) {
            view.hideVersion()
            view.hideUpdateDescription()
        } else {
            view.showVersion(viewModel.version)
            view.showUpdateDescription(viewModel.updateDescription)
        }
    }
}