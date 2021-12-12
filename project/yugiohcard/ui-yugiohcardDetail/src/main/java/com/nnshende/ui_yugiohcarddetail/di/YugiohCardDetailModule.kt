package com.nnshende.ui_yugiohcarddetail.di

import com.nnshende.yugiohcard_interactors.GetYugiohCardFromCache
import com.nnshende.yugiohcard_interactors.YugiohCardInteractors
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object YugiohCardDetailModule {

    @Provides
    @Singleton
    fun provideGetYugiohCardFromCache(
        interactors: YugiohCardInteractors
    ): GetYugiohCardFromCache {
        return interactors.getYugiohCardFromCache
    }
}