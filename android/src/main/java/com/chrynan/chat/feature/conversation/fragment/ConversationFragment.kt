package com.chrynan.chat.feature.conversation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.chrynan.chat.R
import com.chrynan.chat.adapter.AdapterItem
import com.chrynan.chat.feature.conversation.adapter.AttachmentActionTypeAdapter
import com.chrynan.chat.feature.conversation.adapter.AttachmentGalleryAdapter
import com.chrynan.chat.feature.conversation.adapter.message.MessageActionAdapter
import com.chrynan.chat.feature.conversation.adapter.message.MessageFileAdapter
import com.chrynan.chat.feature.conversation.adapter.message.MessageImageAdapter
import com.chrynan.chat.feature.conversation.adapter.message.MessageLinkPreviewAdapter
import com.chrynan.chat.feature.conversation.di.AttachmentActionTypeModule
import com.chrynan.chat.feature.conversation.di.AttachmentGalleryModule
import com.chrynan.chat.feature.conversation.model.AttachmentActionType
import com.chrynan.chat.feature.conversation.presenter.ConversationPresenter
import com.chrynan.chat.feature.conversation.view.ConversationView
import com.chrynan.chat.feature.conversation.view.MessageEditorView
import com.chrynan.chat.feature.conversation.viewmodel.*
import com.chrynan.chat.feature.conversation.widget.MessageEditorLayout
import com.chrynan.chat.feature.media.activity.MediaPreviewActivity
import com.chrynan.chat.feature.media.viewmodel.MediaItemViewModel
import com.chrynan.chat.feature.reaction.fragment.ReactionListFragment
import com.chrynan.chat.feature.reaction.model.Emoji
import com.chrynan.chat.feature.reaction.model.Reaction
import com.chrynan.chat.ui.adapter.core.BaseManagerAdapter
import com.chrynan.chat.ui.fragment.BaseFragment
import kotlinx.android.synthetic.main.fragment_conversation.*
import kotlinx.android.synthetic.main.widget_message_editor.view.*
import javax.inject.Inject
import javax.inject.Named

class ConversationFragment : BaseFragment(),
    ConversationView,
    MessageActionAdapter.MessageActionListener,
    MessageLinkPreviewAdapter.LinkPreviewListener,
    MessageImageAdapter.ImageSelectedListener,
    MessageFileAdapter.FileSelectedListener,
    MessageEditorView,
    AttachmentActionTypeAdapter.AttachmentActionTypeListener,
    AttachmentGalleryAdapter.AttachmentGalleryListener,
    MessageEditorLayout.MessageEditorListener,
    ReactionListFragment.ReactionEmojiSelectedListener {

    companion object {

        fun newInstance() = ConversationFragment()
    }

    @Inject
    override lateinit var presenter: ConversationPresenter

    @Inject
    lateinit var adapter: BaseManagerAdapter<AdapterItem>

    @Inject
    lateinit var layoutManager: LinearLayoutManager

    @Inject
    @field:Named(AttachmentActionTypeModule.NAME_LAYOUT_MANAGER)
    lateinit var attachmentTypeLayoutManager: LinearLayoutManager

    @Inject
    @field:Named(AttachmentActionTypeModule.NAME_MANAGER_ADAPTER)
    lateinit var attachmentTypeAdapter: BaseManagerAdapter<AdapterItem>

    @Inject
    @field:Named(AttachmentGalleryModule.NAME_LAYOUT_MANAGER)
    lateinit var attachmentGalleryLayoutManager: LinearLayoutManager

    @Inject
    @field:Named(AttachmentGalleryModule.NAME_MANAGER_ADAPTER)
    lateinit var attachmentGalleryAdapter: BaseManagerAdapter<AdapterItem>

    private val spacingSmall by lazy { resources.getDimensionPixelSize(R.dimen.spacing_small) }

    private val reactionListDialogFragment by lazy { ReactionListFragment.newInstance() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_conversation, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        conversationRecyclerView?.adapter = adapter
        conversationRecyclerView?.layoutManager = layoutManager

        conversationMessageEditorLayout?.addOnLayoutChangeListener { _, _, top, _, bottom, _, _, _, _ ->
            conversationRecyclerView?.apply {
                setPaddingRelative(
                    paddingStart,
                    paddingTop,
                    paddingEnd,
                    bottom - top + spacingSmall
                )
            }
        }

        conversationMessageEditorLayout?.messageEditorListener = this

        conversationMessageEditorLayout?.messageEditorMediaRecyclerView?.apply {
            adapter = attachmentGalleryAdapter
            layoutManager = attachmentGalleryLayoutManager
        }

        conversationMessageEditorLayout?.messageEditorAttachmentTypeRecyclerView?.apply {
            adapter = attachmentTypeAdapter
            layoutManager = attachmentTypeLayoutManager
        }

        presenter.getInitialMessageItems()
    }

    override fun showMessageItems(items: List<MessageListItemViewModel>) {
        adapter.items = items
    }

    override fun onSelectReactionSelected() {
        reactionListDialogFragment.show(childFragmentManager, "ReactionListFragment")
    }

    override fun onRemoveReactionSelected(reaction: Reaction, item: MessageReactionItemViewModel) {

    }

    override fun onAddReactionSelected(
        reaction: Reaction,
        item: MessageReactionItemViewModel
    ) {
    }

    override fun onMessageThreadSelected(item: MessageActionItemViewModel) {
    }

    override fun onLinkPreviewSelected(item: MessageLinkPreviewItemViewModel) {

    }

    override fun onImageSelected(item: MessageImageItemViewModel) {
        startActivity(
            MediaPreviewActivity.newVideoIntent(
                context!!,
                MediaItemViewModel(
                    uri = "https://www.w3schools.com/html/mov_bbb.mp4"
                )
            )
        )
    }

    override fun onFileSelected(item: MessageFileItemViewModel) {

    }

    override fun showTextInput(input: String) {
        conversationMessageEditorLayout?.showTextInput(input)
    }

    override fun toggleMediaListVisibility(isVisible: Boolean) {
        conversationMessageEditorLayout?.toggleMediaListVisibility(isVisible)
    }

    override fun toggleAttachmentTypeListVisibility(isVisible: Boolean) {
        conversationMessageEditorLayout?.toggleAttachmentTypeListVisibility(isVisible)
    }

    override fun toggleAttachmentListVisibility(isVisible: Boolean) {
        conversationMessageEditorLayout?.toggleAttachmentListVisibility(isVisible)
    }

    override fun toggleAttachmentBackgroundVisibility(isVisible: Boolean) {
        conversationMessageEditorLayout?.toggleAttachmentBackgroundVisibility(isVisible)
    }

    override fun onAttachmentActionTypeSelected(type: AttachmentActionType) {

    }

    override fun onGalleryItemSelected(item: AttachmentGalleryItemViewModel) {

    }

    override fun onAttachmentButtonSelected() = presenter.handleAttachmentButtonSelected()

    override fun onActionButtonSelected() = presenter.handleActionButtonSelected()

    override fun onReactionEmojiSelected(emoji: Emoji) {

    }
}