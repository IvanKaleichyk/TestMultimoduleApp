package com.koleychik.feature_clothes.repository

import com.koleychik.core_db.api.MainDao
import com.koleychik.data.MainModel
import com.koleychik.feature_buy_api.BuyRepository
import javax.inject.Inject

internal class ClothesFeatureRepositoryImpl @Inject constructor(
    private val dao: MainDao,
    private val buyRepository: BuyRepository
) :
    ClothesFeatureRepository {

    override fun getModel(): MainModel = dao.getModel()
    override fun buy(model: MainModel) {
        buyRepository.buy(model)
    }

}