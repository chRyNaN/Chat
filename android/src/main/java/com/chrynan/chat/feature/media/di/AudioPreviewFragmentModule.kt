package com.chrynan.chat.feature.media.di

import com.chrynan.chat.di.scope.FragmentScope
import com.chrynan.chat.feature.media.fragment.AudioPreviewFragment
import com.chrynan.chat.feature.media.view.AudioPreviewView
import dagger.Binds
import dagger.Module

@Module
abstract class AudioPreviewFragmentModule {

    @Binds
    @FragmentScope
    abstract fun bindAudioPreviewView(fragment: AudioPreviewFragment): AudioPreviewView
}