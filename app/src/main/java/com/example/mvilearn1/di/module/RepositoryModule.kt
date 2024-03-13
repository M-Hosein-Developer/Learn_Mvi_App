package com.example.mvilearn1.di.module

import com.example.mvilearn1.model.api.ApiHelper
import com.example.mvilearn1.model.api.ApiHelperImpl
import com.example.mvilearn1.model.repository.MainRepository
import com.example.mvilearn1.model.repository.MainRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {


    @Binds
    abstract fun mainRepository(repositoryImpl: MainRepositoryImpl) : MainRepository

    @Binds
    abstract fun apiHelper(apiHelper: ApiHelperImpl) : ApiHelper

}