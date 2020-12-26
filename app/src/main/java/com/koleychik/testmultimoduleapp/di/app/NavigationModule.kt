package com.koleychik.testmultimoduleapp.di.app

import com.koleychik.feature_clothes.navigation.ClothesNavigator
import com.koleychik.testmultimoduleapp.MainStarter
import com.koleychik.testmultimoduleapp.navigation.Navigator
import dagger.Binds
import dagger.Module

@Module
abstract class NavigationModule {

    @Binds
    abstract fun provideClothesNavigator(impl: Navigator): ClothesNavigator

    @Binds
    abstract fun provideMainStarter(impl: Navigator): MainStarter


}