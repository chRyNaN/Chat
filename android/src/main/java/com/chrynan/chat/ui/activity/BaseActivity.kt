package com.chrynan.chat.ui.activity

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.coroutineScope
import com.chrynan.chat.R
import com.chrynan.chat.coroutines.ActivityCoroutineScope
import com.chrynan.chat.navigator.Navigator
import com.chrynan.chat.presenter.Presenter
import kotlin.coroutines.CoroutineContext

abstract class BaseActivity : FragmentActivity(),
    ActivityCoroutineScope,
    Navigator {

    override val coroutineContext: CoroutineContext
        get() = lifecycle.coroutineScope.coroutineContext

    protected open val presenter: Presenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bindToPresenter()
    }

    override fun onRestart() {
        super.onRestart()

        bindToPresenter()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        unbindFromPresenter()

        super.onSaveInstanceState(outState)
    }

    override fun onDestroy() {
        unbindFromPresenter()

        super.onDestroy()
    }

    override fun goBack() {
        this.onBackPressed()
    }

    fun goToFragment(
        fragment: Fragment,
        fragmentContainerId: Int = R.id.fragmentContainer
    ) {
        supportFragmentManager.let {
            it.beginTransaction().apply {
                replace(fragmentContainerId, fragment)

                commitNow()
            }
        }
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