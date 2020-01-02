package com.chrynan.chat.di.module.fragment

import androidx.recyclerview.widget.LinearLayoutManager
import com.chrynan.aaaah.ItemListUpdater
import com.chrynan.chat.adapter.*
import com.chrynan.chat.di.module.Module
import com.chrynan.chat.di.scope.FragmentScope
import com.chrynan.chat.ui.adapter.contact.ContactInfoActionAdapter
import com.chrynan.chat.ui.adapter.contact.ContactInfoHeaderAdapter
import com.chrynan.chat.ui.adapter.contact.ContactInfoListItemAdapter
import com.chrynan.chat.ui.adapter.core.BaseManagerAdapter
import com.chrynan.chat.ui.adapter.processing.AndroidDiffDispatcher
import com.chrynan.chat.ui.adapter.processing.AndroidDiffProcessor
import com.chrynan.chat.ui.fragment.ContactInfoFragment
import com.chrynan.chat.utils.ActivityContext
import com.chrynan.chat.view.ContactInfoView
import dagger.Binds
import dagger.Provides

@Module
abstract class ContactInfoFragmentModule {

    @Module
    companion object {

        @Provides
        @JvmStatic
        @FragmentScope
        fun provideBaseManagerAdapter(
            layoutManager: LinearLayoutManager,
            headerAdapter: ContactInfoHeaderAdapter,
            actionsAdapter: ContactInfoActionAdapter,
            listItemAdapter: ContactInfoListItemAdapter
        ): BaseManagerAdapter<AdapterItem> =
            BaseManagerAdapter(
                adapters = setOf(headerAdapter, actionsAdapter, listItemAdapter),
                layoutManager = layoutManager
            )

        @Provides
        @JvmStatic
        @FragmentScope
        fun provideLayoutManager(context: ActivityContext) = LinearLayoutManager(context)

        @Provides
        @JvmStatic
        @FragmentScope
        fun provideAaaahDiffProcessor(): com.chrynan.aaaah.DiffProcessor<AdapterItem> =
            com.chrynan.aaaah.DiffProcessor()
    }

    @Binds
    @FragmentScope
    abstract fun bindContactListView(fragment: ContactInfoFragment): ContactInfoView

    @Binds
    @FragmentScope
    abstract fun bindContactInfoListItemSelectedListener(fragment: ContactInfoFragment): ContactInfoListItemAdapter.ContactInfoListItemSelectedListener

    @Binds
    @FragmentScope
    abstract fun bindContactInfoActionSelectedListener(fragment: ContactInfoFragment): ContactInfoActionAdapter.ContactInfoActionSelectedListener

    @Binds
    @FragmentScope
    abstract fun bindItemListUpdater(adapter: BaseManagerAdapter<AdapterItem>): ItemListUpdater<AdapterItem>

    @Binds
    @FragmentScope
    abstract fun bindDiffProcessor(processor: AndroidDiffProcessor<AdapterItem>): DiffProcessor<AdapterItem>

    @Binds
    @FragmentScope
    abstract fun bindDiffDispatcher(dispatcher: AndroidDiffDispatcher<AdapterItem>): DiffDispatcher<AdapterItem>

    @Binds
    @FragmentScope
    abstract fun bindAdapterItemHandler(handler: BaseAdapterItemHandler<AdapterItem>): AdapterItemHandler<AdapterItem>
}