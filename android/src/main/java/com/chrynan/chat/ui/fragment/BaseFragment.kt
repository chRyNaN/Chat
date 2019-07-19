package com.chrynan.chat.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.chrynan.chat.coroutines.FragmentCoroutineScope
import com.chrynan.chat.presenter.Presenter
import kotlin.coroutines.CoroutineContext

abstract class BaseFragment : Fragment(),
    FragmentCoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = lifecycleScope.coroutineContext

    protected open val presenter: Presenter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bindToPresenter()
    }

    override fun onResume() {
        super.onResume()

        bindToPresenter()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        unbindFromPresenter()

        super.onSaveInstanceState(outState)
    }

    override fun onPause() {
        unbindFromPresenter()

        super.onPause()
    }

    override fun onDestroyView() {
        unbindFromPresenter()

        super.onDestroyView()
    }

    private fun bindToPresenter() {
        if (presenter?.isBound == false) {
            presenter?.bind()
        }
    }

    private fun unbindFromPresenter() {
        if (presenter?.isBound == true) {
            presenter?.unbind()
        }
    }
}