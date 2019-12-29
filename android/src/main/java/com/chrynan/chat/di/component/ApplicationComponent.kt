package com.chrynan.chat.di.component

import com.chrynan.chat.ChatApplication
import com.chrynan.chat.di.module.ActivityBuilderModule
import com.chrynan.chat.di.module.ApplicationModule
import com.chrynan.chat.di.scope.Singleton
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ApplicationModule::class,
        ActivityBuilderModule::class
    ]
)
interface ApplicationComponent : AndroidInjector<ChatApplication> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(app: ChatApplication): Builder

        fun build(): ApplicationComponent
    }
}