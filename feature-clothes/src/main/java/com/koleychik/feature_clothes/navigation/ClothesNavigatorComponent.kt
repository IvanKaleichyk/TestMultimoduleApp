package com.koleychik.feature_clothes.navigation

import com.koleychik.module_injector.NavigatorComponent

object ClothesNavigatorComponent : NavigatorComponent<ClothesNavigator> {

    private var navigator: ClothesNavigator? = null

    override fun init(navigator: ClothesNavigator) {
        this.navigator = navigator
    }

    override fun get(): ClothesNavigator = navigator!!

    override fun reset() {
        navigator = null
    }
}