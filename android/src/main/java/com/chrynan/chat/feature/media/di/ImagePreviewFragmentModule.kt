package com.chrynan.chat.feature.media.di

import com.chrynan.chat.di.scope.FragmentScope
import com.chrynan.chat.feature.media.fragment.ImagePreviewFragment
import com.chrynan.chat.feature.media.view.ImagePreviewView
import dagger.Binds
import dagger.Module

@Module
abstract class ImagePreviewFragmentModule {

    @Binds
    @FragmentScope
    abstract fun bindImagePreviewView(fragment: ImagePreviewFragment): ImagePreviewView
}