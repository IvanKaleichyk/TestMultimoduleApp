package com.koleychik.feature_clothes.di

import androidx.lifecycle.ViewModel
import com.koleychik.core_annotation.ViewModelKey
import com.koleychik.feature_clothes.screen.ClothesViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
internal abstract class ViewModelsModule {

    @Binds
    @IntoMap
    @ViewModelKey(ClothesViewModel::class)
    abstract fun provideClothesViewModel(viewModel: ClothesViewModel): ViewModel
}