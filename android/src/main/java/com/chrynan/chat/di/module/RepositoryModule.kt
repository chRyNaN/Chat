package com.chrynan.chat.di.module

import com.chrynan.chat.repository.ContactListRepository
import com.chrynan.chat.repository.ProjectDependencyRepository
import com.chrynan.chat.source.ContactListSource
import com.chrynan.chat.source.ProjectDependencySource
import dagger.Binds

@Module
abstract class RepositoryModule {

    @Binds
    abstract fun bindProjectDependencyRepository(source: ProjectDependencySource): ProjectDependencyRepository

    @Binds
    abstract fun bindContactListRepository(source: ContactListSource): ContactListRepository
}