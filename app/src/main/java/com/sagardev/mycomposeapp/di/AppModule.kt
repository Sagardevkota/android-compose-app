package com.sagardev.mycomposeapp.di

import android.content.Context
import com.sagardev.mycomposeapp.BaseApplication
import com.sagardev.mycomposeapp.mapper.EntityMapper
import com.sagardev.mycomposeapp.mapper.PostMapper
import com.sagardev.mycomposeapp.model.Post
import com.sagardev.mycomposeapp.network.APIService.ApiService
import com.sagardev.mycomposeapp.repository.PostRepository
import com.sagardev.mycomposeapp.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule{

    @Singleton
    @Provides
    fun provideApplication(@ApplicationContext app:Context):BaseApplication{
        return app as BaseApplication
    }

    @Singleton
    @Provides
    fun provideUserRepository():UserRepository{
        return UserRepository()
    }

    @Singleton
    @Provides
    fun provideDtoMapper():PostMapper{
        return PostMapper()
    }



    @Singleton
    @Provides
    fun providePostRepository(postMapper: PostMapper,apiService: ApiService):PostRepository{
        return PostRepository(postMapper = postMapper,apiService = apiService)
    }




}