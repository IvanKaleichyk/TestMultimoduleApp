package com.koleychik.testmultimoduleapp.di.app

import android.app.Application
import android.content.Context
import com.koleychik.core_db.api.MainDao
import com.koleychik.core_db.impl.di.DbComponent
import com.koleychik.feature_buy_api.BuyFeatureApi
import com.koleychik.feature_buy_api.BuyRepository
import com.koleychik.feature_buy_impl.di.BuyComponentHolder
import com.koleychik.feature_buy_impl.di.BuyFeatureDependencies
import com.koleychik.feature_clothes.ClothesFeatureApi
import com.koleychik.feature_clothes.di.ClothesFeatureComponentHolder
import com.koleychik.feature_clothes.di.ClothesFeatureDependencies
import com.koleychik.feature_clothes.navigation.ClothesNavigator
import com.koleychik.feature_clothes.navigation.ClothesNavigatorComponent
import com.koleychik.testmultimoduleapp.navigation.Navigator
import dagger.Module
import dagger.Provides
import javax.inject.Provider
import javax.inject.Singleton

@Module
class AppModule(private val application: Application) {

    @Singleton
    @Provides
    fun provideContext() = application.applicationContext

    @Singleton
    @Provides
    fun provideNavigator(clothesFeatureApi: Provider<ClothesFeatureApi>): Navigator =
        Navigator(clothesFeatureApi)

    @Singleton
    @Provides
    fun provideClothesFeatureDependencies(
        buyFeatureApi: BuyFeatureApi,
        clothesNavigator: ClothesNavigator
    ) = object : ClothesFeatureDependencies {
        override fun db(): MainDao = DbComponent.get().getMainDao()
        override fun buyRepository(): BuyRepository = buyFeatureApi.repository()
        override fun clothesNavigator(): ClothesNavigator = clothesNavigator
    }

    @Singleton
    @Provides
    fun provideBuyFeatureDependencies(context: Context) = object : BuyFeatureDependencies {
        override fun context(): Context = context
    }

    @Provides
    fun provideClothesFeatureApi(
        dependencies: ClothesFeatureDependencies,
        navigator: Navigator,
    ): ClothesFeatureApi {
        ClothesFeatureComponentHolder.init(dependencies)
        ClothesNavigatorComponent.init(navigator)
        return ClothesFeatureComponentHolder.get()
    }

    @Provides
    fun provideBuyFeatureApi(dependencies: BuyFeatureDependencies): BuyFeatureApi {
        BuyComponentHolder.init(dependencies)
        return BuyComponentHolder.get()
    }
}