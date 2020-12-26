package com.koleychik.feature_buy_impl.di

import android.content.Context
import com.koleychik.module_injector.BaseDependencies

interface BuyFeatureDependencies: BaseDependencies{

    fun context() : Context

}