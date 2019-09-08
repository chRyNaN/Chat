package com.chrynan.chat.ui.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
import com.chrynan.chat.R
import com.chrynan.chat.ui.fragment.WebFragment

class WebActivity : BaseActivity() {

    companion object {

        private const val KEY_URL = "keyUrl"
        private const val KEY_TITLE = "keyTitle"

        fun newIntent(context: Context, url: String, title: String? = null) =
            Intent(context, WebActivity::class.java).apply {
                putExtra(KEY_URL, url)
                putExtra(KEY_TITLE, title)
            }
    }

    private val toolbar by lazy { findViewById<Toolbar>(R.id.toolbar) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)

        val title = intent.extras?.getString(KEY_TITLE)

        toolbar.apply {
            visibility = if (title != null) View.VISIBLE else View.GONE
            this.title = title
            setNavigationIcon(R.drawable.ic_toolbar_back)
            setNavigationOnClickListener { goBack() }
        }

        intent.extras?.getString(KEY_URL)?.let {
            goToFragment(WebFragment.newInstance(url = it))
        }
    }
}