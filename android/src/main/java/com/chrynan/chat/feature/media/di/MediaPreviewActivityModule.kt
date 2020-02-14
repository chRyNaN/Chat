package com.chrynan.chat.feature.media.di

import com.chrynan.chat.di.module.AdapterModule
import com.chrynan.chat.di.scope.ActivityScope
import com.chrynan.chat.di.scope.FragmentScope
import com.chrynan.chat.feature.media.activity.MediaPreviewActivity
import com.chrynan.chat.feature.media.fragment.ImagePreviewFragment
import com.chrynan.chat.feature.media.util.ToggleSystemUIListener
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MediaPreviewActivityModule {

    @FragmentScope
    @ContributesAndroidInjector(modules = [ImagePreviewFragmentModule::class, AdapterModule::class])
    abstract fun imagePreviewInjector(): ImagePreviewFragment

    @ActivityScope
    @Binds
    abstract fun bindToggleSystemUIListener(activity: MediaPreviewActivity): ToggleSystemUIListener
}