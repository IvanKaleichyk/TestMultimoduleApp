package com.koleychik.feature_buy_api

import com.koleychik.data.MainModel

interface BuyRepository{
    fun buy(model: MainModel)
}