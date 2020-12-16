package com.koleychik.feature_clothes.di

import com.koleychik.core_annotation.general.PerFeature
import com.koleychik.feature_clothes.repository.ClothesFeatureRepository
import com.koleychik.feature_clothes.repository.ClothesFeatureRepositoryImpl
import dagger.Binds
import dagger.Module

@Module
internal abstract class ClothesModule {

    @PerFeature
    @Binds
    abstract fun provideFeatureRepository(repositoryImpl: ClothesFeatureRepositoryImpl): ClothesFeatureRepository
}