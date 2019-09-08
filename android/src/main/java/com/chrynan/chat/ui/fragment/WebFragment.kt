package com.chrynan.chat.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import com.chrynan.chat.R

class WebFragment : BaseFragment() {

    companion object {

        private const val KEY_URL = "keyUrl"

        fun newInstance(url: String) = WebFragment().apply {
            arguments = Bundle().apply {
                putString(KEY_URL, url)
            }
        }
    }

    private val url by lazy { arguments?.getString(KEY_URL)!! }

    private val webView by lazy { view!!.findViewById<WebView>(R.id.webView) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_web, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        webView.loadUrl(url)
    }
}