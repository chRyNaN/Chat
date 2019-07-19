package com.chrynan.chat.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.chrynan.chat.R
import com.google.android.material.appbar.CollapsingToolbarLayout

class FeedFragment : BaseFragment() {

    companion object {

        fun newInstance() = FeedFragment()
    }

    private val collapsingToolbarLayout by lazy { view!!.findViewById<CollapsingToolbarLayout>(R.id.collapsingToolbarLayout) }

    private val titleText by lazy { getString(R.string.app_bar_title_feed) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_feed, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        collapsingToolbarLayout.title = titleText
    }
}