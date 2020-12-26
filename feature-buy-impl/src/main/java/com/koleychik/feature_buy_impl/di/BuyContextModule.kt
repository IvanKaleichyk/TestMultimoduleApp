package com.koleychik.feature_buy_impl.di

import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class BuyContextModule(private val context: Context) {

    @Provides
    fun provideContext() = context

}