package com.koleychik.testmultimoduleapp.di.activity

import com.koleychik.core_annotation.general.PerScreen
import com.koleychik.feature_clothes.ClothesNavigator
import com.koleychik.testmultimoduleapp.Navigator
import dagger.Binds
import dagger.Module

@Module
internal abstract class NavigationModule {

    @PerScreen
    @Binds
    abstract fun bindClothesNavigator(navigator: Navigator): ClothesNavigator

}