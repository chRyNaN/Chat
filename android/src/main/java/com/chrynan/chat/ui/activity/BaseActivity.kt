package com.chrynan.chat.ui.activity

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.coroutineScope
import com.chrynan.chat.R
import com.chrynan.chat.coroutines.ActivityCoroutineScope
import com.chrynan.chat.navigator.Navigator
import com.chrynan.chat.presenter.BasePresenter
import dagger.android.support.DaggerAppCompatActivity
import kotlin.coroutines.CoroutineContext

abstract class BaseActivity : DaggerAppCompatActivity(),
    ActivityCoroutineScope,
    Navigator {

    override val coroutineContext: CoroutineContext
        get() = lifecycle.coroutineScope.coroutineContext

    protected open val presenter: BasePresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        presenter?.bind()
    }

    override fun onRestart() {
        super.onRestart()

        presenter?.bind()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        presenter?.unbind()

        super.onSaveInstanceState(outState)
    }

    override fun onDestroy() {
        presenter?.unbind()

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
}