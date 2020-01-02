package com.chrynan.chat.ui.activity

import android.content.Intent
import android.os.Bundle
import com.chrynan.chat.R
import com.chrynan.chat.utils.ActivityContext

class MediaPreviewActivity : BaseActivity() {

    companion object {

        fun newIntent(context: ActivityContext) = Intent(context, MediaPreviewActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_fragment_container)
    }
}