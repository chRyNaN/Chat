package com.chrynan.chat.di.module.fragment

import com.chrynan.chat.di.module.Module
import com.chrynan.chat.di.scope.FragmentScope
import com.chrynan.chat.ui.fragment.EditContactFragment
import com.chrynan.chat.view.EditContactView
import dagger.Binds

@Module
abstract class EditContactFragmentModule {

    @Binds
    @FragmentScope
    abstract fun bindEditContactView(fragment: EditContactFragment): EditContactView
}