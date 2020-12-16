package com.koleychik.feature_buy_api

import com.koleychik.data.MainModel
import com.koleychik.module_injector.BaseApi

interface BuyRepository{
    fun buy(model: MainModel)
}