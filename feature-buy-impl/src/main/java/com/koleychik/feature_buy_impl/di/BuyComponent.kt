package com.koleychik.feature_buy_impl.di

import com.koleychik.core_annotation.general.PerFeature
import com.koleychik.feature_buy_api.BuyFeatureApi
import dagger.Component

@Component(
    modules = [BuyModule::class],
    dependencies = [BuyFeatureDependencies::class]
)
@PerFeature
interface BuyComponent : BuyFeatureApi {

    companion object {
        fun initAndGet(dependencies: BuyFeatureDependencies): BuyComponent =
            DaggerBuyComponent.builder().buyFeatureDependencies(dependencies).build()
    }

}