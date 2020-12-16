package com.koleychik.testmultimoduleapp.di.app

import android.app.Application
import com.koleychik.core_db.api.CoreDbApi
import com.koleychik.core_db.api.MainDao
import com.koleychik.core_db.impl.di.DbComponent
import com.koleychik.feature_buy_api.BuyFeatureApi
import com.koleychik.feature_buy_api.BuyRepository
import com.koleychik.feature_buy_impl.di.BuyComponentHolder
import com.koleychik.feature_buy_impl.di.BuyFeatureDependencies
import com.koleychik.feature_clothes.ClothesFeatureApi
import com.koleychik.feature_clothes.di.ClothesFeatureComponentHolder
import com.koleychik.feature_clothes.di.ClothesFeatureDependencies
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val application: Application) {

    @Singleton
    @Provides
    fun provideContext() = application.applicationContext

    @Singleton
    @Provides
    fun provideClothesFeatureDependencies(
        buyFeatureApi: BuyFeatureApi
    ) = object : ClothesFeatureDependencies {
        override fun db(): MainDao = DbComponent.get().getMainDao()
        override fun buyRepository(): BuyRepository = buyFeatureApi.repository()
    }

    @Singleton
    @Provides
    fun provideBuyFeatureDependencies() = object : BuyFeatureDependencies{}

    @Provides
    fun provideClothesFeatureApi(dependencies: ClothesFeatureDependencies) : ClothesFeatureApi{
        ClothesFeatureComponentHolder.init(dependencies)
        return ClothesFeatureComponentHolder.get()
    }

    @Provides
    fun provideBuyFeatureApi(dependencies: BuyFeatureDependencies) : BuyFeatureApi{
        BuyComponentHolder.init(dependencies)
        return BuyComponentHolder.get()
    }
}