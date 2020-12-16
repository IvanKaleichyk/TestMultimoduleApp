package com.koleychik.feature_buy_api

import com.koleychik.module_injector.BaseApi

interface BuyFeatureApi : BaseApi {

    fun repository() : BuyRepository
}