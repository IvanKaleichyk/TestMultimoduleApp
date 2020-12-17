package com.koleychik.feature_clothes

import com.koleychik.feature_clothes.navigation.ClothesNavigator
import com.koleychik.module_injector.BaseApi

interface ClothesFeatureApi: BaseApi {
    fun navigator() : ClothesNavigator
}