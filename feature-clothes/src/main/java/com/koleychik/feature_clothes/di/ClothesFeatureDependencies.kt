package com.koleychik.feature_clothes.di

import com.koleychik.core_db.api.MainDao
import com.koleychik.feature_buy_api.BuyRepository
import com.koleychik.feature_clothes.navigation.ClothesNavigator
import com.koleychik.module_injector.BaseDependencies

interface ClothesFeatureDependencies : BaseDependencies{

    fun db(): MainDao

    fun buyRepository() : BuyRepository

    fun clothesNavigator(): ClothesNavigator
}