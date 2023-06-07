package com.vouria.app.archtest.login.di.module

import com.vouria.app.archtest.core.data.local.AppDataBase
import com.vouria.app.archtest.login.data.local.LocalDataSource
import com.vouria.app.archtest.login.data.local.dao.UserDao
import com.vouria.app.archtest.login.data.remote.RemoteDataSource
import com.vouria.app.archtest.login.data.remote.interfaces.LoginApiService
import com.vouria.app.archtest.login.data.repository.UserRepository
import com.vouria.app.archtest.login.domain.repository.IUserRepository
import com.vouria.app.archtest.login.ui.viewmodel.LoginViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LoginModule {

    @Provides
    @Singleton
    fun provideRemoteDataSource(loginApiService: LoginApiService): RemoteDataSource =
        RemoteDataSource(loginApiService)

    @Provides
    @Singleton
    fun provideLocalDataSource(userDao: UserDao): LocalDataSource = LocalDataSource(userDao)

    @Provides
    @Singleton
    fun provideUserDao(appDataBase: AppDataBase): UserDao = appDataBase.userDao()

    @Provides
    @Singleton
    fun provideUserRepository(
        remote: RemoteDataSource,
        local: LocalDataSource,
    ): IUserRepository =
        UserRepository(remote, local)

    @Provides
    @Singleton
    fun provideUserViewModel(userRepository: IUserRepository): LoginViewModel =
        LoginViewModel(userRepository)
}