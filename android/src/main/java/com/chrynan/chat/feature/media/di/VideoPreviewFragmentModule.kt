package com.chrynan.chat.feature.media.di

import com.chrynan.chat.di.scope.FragmentScope
import com.chrynan.chat.feature.media.fragment.VideoPreviewFragment
import com.chrynan.chat.feature.media.view.VideoPreviewView
import dagger.Binds
import dagger.Module

@Module
abstract class VideoPreviewFragmentModule {

    @Binds
    @FragmentScope
    abstract fun bindVideoPreviewView(fragment: VideoPreviewFragment): VideoPreviewView
}