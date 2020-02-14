package com.chrynan.chat.feature.contact.di

import com.chrynan.chat.di.module.Module
import com.chrynan.chat.di.scope.FragmentScope
import com.chrynan.chat.feature.contact.view.EditContactView
import com.chrynan.chat.feature.contact.fragment.EditContactFragment
import dagger.Binds

@Module
abstract class EditContactFragmentModule {

    @Binds
    @FragmentScope
    abstract fun bindEditContactView(fragment: EditContactFragment): EditContactView
}