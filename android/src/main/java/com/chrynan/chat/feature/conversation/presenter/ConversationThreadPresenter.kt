package com.chrynan.chat.feature.conversation.presenter

import com.chrynan.chat.adapter.AdapterItem
import com.chrynan.chat.adapter.AdapterItemHandler
import com.chrynan.chat.coroutines.CoroutineDispatchers
import com.chrynan.chat.presenter.BasePresenter
import javax.inject.Inject

class ConversationThreadPresenter @Inject constructor(
    dispatchers: CoroutineDispatchers,
    private val adapterItemHandler: AdapterItemHandler<AdapterItem>
) : BasePresenter(dispatchers = dispatchers) {


}