package com.koleychik.feature_clothes.repository

import com.koleychik.data.MainModel
import com.koleychik.feature_buy_api.BuyRepository

interface ClothesFeatureRepository {

    fun getModel(): MainModel

    fun buy(model: MainModel)
}