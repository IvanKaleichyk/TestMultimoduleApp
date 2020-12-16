package com.koleychik.feature_buy_impl.di

import com.koleychik.feature_buy_api.BuyFeatureApi
import com.koleychik.module_injector.ComponentHolder

object BuyComponentHolder : ComponentHolder<BuyFeatureApi, BuyFeatureDependencies> {

    private var component : BuyComponent? = null

    override fun init(dependency: BuyFeatureDependencies) {
        if (component == null) synchronized(BuyComponentHolder::class.java){
            if (component == null) component = BuyComponent.initAndGet(dependency)
        }
    }

    override fun get(): BuyFeatureApi = component!!

    override fun reset() {
        component = null
    }
}