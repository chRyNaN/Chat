package com.chrynan.chat.feature.conversation.adapter.message

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.chrynan.aaaah.Adapter
import com.chrynan.aaaah.AdapterViewType
import com.chrynan.aaaah.ViewType
import com.chrynan.aaaah.from
import com.chrynan.chat.R
import com.chrynan.chat.feature.conversation.viewmodel.MessageVideoItemViewModel
import com.chrynan.chat.media.MediaPlayerViewController
import com.chrynan.chat.ui.adapter.core.BaseAdapter
import kotlinx.android.synthetic.main.adapter_message_video.view.*
import javax.inject.Inject


@Adapter
class MessageVideoAdapter @Inject constructor(
    private val mediaPlayerViewController: MediaPlayerViewController
) : BaseAdapter<MessageVideoItemViewModel>() {

    override val viewType = AdapterViewType.from(this::class.java)

    override fun onHandlesItem(item: Any) = item is MessageVideoItemViewModel

    override fun onCreateView(parent: ViewGroup, viewType: ViewType): View =
        LayoutInflater.from(parent.context).inflate(R.layout.adapter_message_video, parent, false)

    override fun onBindItem(view: View, item: MessageVideoItemViewModel) {
        view.apply {
            mediaItemWidget?.let { mediaPlayerViewController.bindOrEnter(view = it, video = item.video) }
        }
    }

    override fun onEnter(view: View?, item: MessageVideoItemViewModel?) {
        super.onEnter(view, item)
        view?.apply {
            mediaItemWidget?.let { mediaItemView ->
                item?.video?.let { video ->
                    mediaPlayerViewController.bindOrEnter(mediaItemView, video)
                }
            }
        }
    }

    override fun onExit(view: View?, item: MessageVideoItemViewModel?) {
        super.onExit(view, item)
        view?.apply {
            mediaItemWidget?.let { mediaPlayerViewController.exit(it) }
        }
    }

    override fun onDetachedFromRecyclerView(recyclerView: RecyclerView) {
        super.onDetachedFromRecyclerView(recyclerView)
        mediaPlayerViewController.detach()
    }
}