package com.koleychik.feature_buy_impl.di

import com.koleychik.core_annotation.general.PerFeature
import com.koleychik.feature_buy_api.BuyRepository
import com.koleychik.feature_buy_impl.BuyRepositoryImpl
import dagger.Binds
import dagger.Module

@Module
internal abstract class BuyModule {
    @Binds
    @PerFeature
    abstract fun provideRepository(repositoryImpl: BuyRepositoryImpl): BuyRepository
}