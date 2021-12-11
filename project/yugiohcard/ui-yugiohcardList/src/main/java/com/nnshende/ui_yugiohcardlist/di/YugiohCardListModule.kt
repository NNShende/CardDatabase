package com.nnshende.ui_yugiohcardlist.di

import com.nnshende.yugiohcard_interactors.GetYugiohCards
import com.nnshende.yugiohcard_interactors.YugiohCardInteractors
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object YugiohCardListModule {

    @Provides
    @Singleton
    fun provideGetYugiohCards(
        interactors: YugiohCardInteractors
    ): GetYugiohCards {
        return interactors.getYugiohCards
    }
}