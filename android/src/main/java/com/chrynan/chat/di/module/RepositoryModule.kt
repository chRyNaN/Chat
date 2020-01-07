package com.chrynan.chat.di.module

import com.chrynan.chat.repository.BriefUserConnectionRepository
import com.chrynan.chat.repository.ProjectDependencyRepository
import com.chrynan.chat.repository.UserConnectionRepository
import com.chrynan.chat.source.BriefUserConnectionSource
import com.chrynan.chat.source.ProjectDependencySource
import com.chrynan.chat.source.UserConnectionSource
import dagger.Binds

@Module
abstract class RepositoryModule {

    @Binds
    abstract fun bindProjectDependencyRepository(source: ProjectDependencySource): ProjectDependencyRepository

    @Binds
    abstract fun bindFullUserConnectionRepository(source: UserConnectionSource): UserConnectionRepository

    @Binds
    abstract fun bindBriefUserConnectionRepository(source: BriefUserConnectionSource): BriefUserConnectionRepository
}