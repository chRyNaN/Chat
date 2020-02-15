package com.chrynan.chat.feature.media.di

import com.chrynan.chat.di.module.AdapterModule
import com.chrynan.chat.di.module.MediaModule
import com.chrynan.chat.di.scope.ActivityScope
import com.chrynan.chat.di.scope.FragmentScope
import com.chrynan.chat.feature.media.activity.MediaPreviewActivity
import com.chrynan.chat.feature.media.fragment.AudioPreviewFragment
import com.chrynan.chat.feature.media.fragment.ImagePreviewFragment
import com.chrynan.chat.feature.media.fragment.VideoPreviewFragment
import com.chrynan.chat.feature.media.util.ToggleSystemUIListener
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MediaPreviewActivityModule {

    @FragmentScope
    @ContributesAndroidInjector(modules = [ImagePreviewFragmentModule::class, AdapterModule::class])
    abstract fun imagePreviewInjector(): ImagePreviewFragment

    @FragmentScope
    @ContributesAndroidInjector(modules = [AudioPreviewFragmentModule::class, AdapterModule::class])
    abstract fun audioPreviewInjector(): AudioPreviewFragment

    @FragmentScope
    @ContributesAndroidInjector(modules = [VideoPreviewFragmentModule::class, AdapterModule::class, MediaModule::class])
    abstract fun videoPreviewInjector(): VideoPreviewFragment

    @ActivityScope
    @Binds
    abstract fun bindToggleSystemUIListener(activity: MediaPreviewActivity): ToggleSystemUIListener
}