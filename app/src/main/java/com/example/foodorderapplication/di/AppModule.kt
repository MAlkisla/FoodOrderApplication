package com.example.foodorderapplication.di

import com.example.foodorderapplication.data.datasource.CartFoodsDataSource
import com.example.foodorderapplication.data.datasource.FoodsDataSource
import com.example.foodorderapplication.data.repo.CartFoodsRepository
import com.example.foodorderapplication.data.repo.FoodsRepository
import com.example.foodorderapplication.retrofit.ApiUtils
import com.example.foodorderapplication.retrofit.FoodsDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideFoodsRepository(fds:FoodsDataSource): FoodsRepository{
        return FoodsRepository(fds)
    }

    @Provides
    @Singleton
    fun provideFoodsDataSource(fdao: FoodsDao): FoodsDataSource{
        return FoodsDataSource(fdao)
    }

    @Provides
    @Singleton
    fun provideFoodsDao(): FoodsDao {
        return ApiUtils.getFoodsDao()
    }

    @Provides
    @Singleton
    fun provideCartFoodsRepository(cfds:CartFoodsDataSource): CartFoodsRepository{
        return CartFoodsRepository(cfds)
    }

    @Provides
    @Singleton
    fun provideCartFoodsDataSource(fdao: FoodsDao): CartFoodsDataSource{
        return CartFoodsDataSource(fdao)
    }
}