package com.koleychik.feature_clothes.di

import com.koleychik.core_annotation.general.PerFeature
import com.koleychik.feature_clothes.ClothesFeatureApi
import com.koleychik.feature_clothes.screen.ClothesFragment
import dagger.Component

@Component(
    modules = [ClothesModule::class, ViewModelsModule::class],
    dependencies = [ClothesFeatureDependencies::class]
)
@PerFeature
internal abstract class ClothesFeatureComponent : ClothesFeatureApi {

    internal abstract fun inject(fragment: ClothesFragment)

    companion object {
        fun initAndGet(dependencies: ClothesFeatureDependencies): ClothesFeatureComponent =
            DaggerClothesFeatureComponent.builder().clothesFeatureDependencies(dependencies).build()
    }

}