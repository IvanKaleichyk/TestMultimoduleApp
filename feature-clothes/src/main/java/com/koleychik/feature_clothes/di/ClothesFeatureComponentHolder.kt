package com.koleychik.feature_clothes.di

import com.koleychik.feature_clothes.ClothesFeatureApi
import com.koleychik.module_injector.ComponentHolder

object ClothesFeatureComponentHolder : ComponentHolder<ClothesFeatureApi, ClothesFeatureDependencies> {

    private var clothesFeatureComponent: ClothesFeatureComponent? = null

    override fun init(dependency: ClothesFeatureDependencies) {
        if (clothesFeatureComponent == null) synchronized(ClothesFeatureComponentHolder::class.java) {
            if (clothesFeatureComponent == null) clothesFeatureComponent =
                ClothesFeatureComponent.initAndGet(dependency)
        }
    }

    override fun get(): ClothesFeatureApi {
        checkNotNull(clothesFeatureComponent) { "ClothesFeatureComponent was not initialized!" }
        return clothesFeatureComponent!!
    }

    internal fun getComponent(): ClothesFeatureComponent = clothesFeatureComponent!!

    override fun reset() {
        clothesFeatureComponent = null
    }
}