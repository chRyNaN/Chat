package com.chrynan.chat.feature.conversation.presenter

import com.chrynan.chat.adapter.AdapterItem
import com.chrynan.chat.adapter.AdapterItemHandler
import com.chrynan.chat.coroutines.CoroutineDispatchers
import com.chrynan.chat.feature.conversation.di.AttachmentActionTypeModule
import com.chrynan.chat.feature.conversation.model.AttachmentActionType
import com.chrynan.chat.feature.conversation.view.MessageEditorView
import com.chrynan.chat.feature.conversation.viewmodel.AttachmentActionTypeItemViewModel
import com.chrynan.chat.presenter.BasePresenter
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.launchIn
import javax.inject.Inject
import javax.inject.Named

class MessageEditorPresenter @Inject constructor(
    dispatchers: CoroutineDispatchers,
    private val view: MessageEditorView,
    @Named(AttachmentActionTypeModule.NAME_ADAPTER_ITEM_HANDLER) private val attachmentTypeAdapterItemHandler: AdapterItemHandler<AdapterItem>
) : BasePresenter(dispatchers = dispatchers) {

    private val attachmentActionTypeItems = listOf(
        AttachmentActionTypeItemViewModel(
            type = AttachmentActionType.CAMERA,
            title = "Camera"
        ),
        AttachmentActionTypeItemViewModel(
            type = AttachmentActionType.GALLERY,
            title = "Gallery"
        ),
        AttachmentActionTypeItemViewModel(
            type = AttachmentActionType.GIF,
            title = "Gif"
        ),
        AttachmentActionTypeItemViewModel(
            type = AttachmentActionType.FILE,
            title = "File"
        ),
        AttachmentActionTypeItemViewModel(
            type = AttachmentActionType.CONTACT,
            title = "Contact"
        ),
        AttachmentActionTypeItemViewModel(
            type = AttachmentActionType.LOCATION,
            title = "Location"
        )
    )

    private var isAttachmentSelectorVisible = false


    fun setup() {
        attachmentTypeAdapterItemHandler.apply {
            flowOf(attachmentActionTypeItems)
                .calculateAndDispatchDiff()
                .launchIn(this@MessageEditorPresenter)
        }
    }

    fun handleActionButtonSelected() {
        // TODO
    }

    fun handleAttachmentButtonSelected() {
        isAttachmentSelectorVisible = !isAttachmentSelectorVisible

        view.toggleAttachmentTypeListVisibility(isVisible = isAttachmentSelectorVisible)
        view.toggleAttachmentBackgroundVisibility(isVisible = isAttachmentSelectorVisible)
    }
}