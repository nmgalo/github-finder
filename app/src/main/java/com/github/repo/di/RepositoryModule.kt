package com.github.repo.di

import com.github.repo.data.users.UsersRepositoryImpl
import com.github.repo.domain.users.UsersRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun provideUserRepository(usersRepository: UsersRepositoryImpl): UsersRepository
}
