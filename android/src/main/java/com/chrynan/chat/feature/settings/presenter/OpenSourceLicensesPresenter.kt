package com.chrynan.chat.feature.settings.presenter

import com.chrynan.chat.adapter.AdapterItem
import com.chrynan.chat.adapter.AdapterItemHandler
import com.chrynan.chat.coroutines.CoroutineDispatchers
import com.chrynan.chat.coroutines.flowOf
import com.chrynan.chat.feature.settings.mapper.ProjectDependencyMapper
import com.chrynan.chat.presenter.BasePresenter
import com.chrynan.chat.repository.ProjectDependencyRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.launchIn
import javax.inject.Inject

class OpenSourceLicensesPresenter @Inject constructor(
    dispatchers: CoroutineDispatchers,
    adapterItemHandler: AdapterItemHandler<AdapterItem>,
    private val repository: ProjectDependencyRepository,
    private val mapper: ProjectDependencyMapper
) : BasePresenter(dispatchers),
    AdapterItemHandler<AdapterItem> by adapterItemHandler {

    @ExperimentalCoroutinesApi
    fun getLicenses() {
        flowOf {
            repository.getAll()
                .flatMap { mapper.map(it) }
        }.calculateAndDispatchDiff()
            .launchIn(this)
    }
}