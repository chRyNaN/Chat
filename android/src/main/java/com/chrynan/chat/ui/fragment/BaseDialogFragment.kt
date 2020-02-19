package com.chrynan.chat.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import com.chrynan.chat.coroutines.DialogFragmentCoroutineScope
import com.chrynan.chat.presenter.BasePresenter
import dagger.android.support.DaggerDialogFragment
import kotlin.coroutines.CoroutineContext

abstract class BaseDialogFragment : DaggerDialogFragment(),
    DialogFragmentCoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = lifecycleScope.coroutineContext

    protected open val presenter: BasePresenter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter?.bind()
    }

    override fun onResume() {
        super.onResume()

        presenter?.bind()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        presenter?.unbind()

        super.onSaveInstanceState(outState)
    }

    override fun onPause() {
        presenter?.unbind()

        super.onPause()
    }

    override fun onDestroyView() {
        presenter?.unbind()

        super.onDestroyView()
    }
}