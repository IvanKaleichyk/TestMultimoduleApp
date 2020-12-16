package com.koleychik.feature_buy_impl

import android.content.Context
import android.widget.Toast
import com.koleychik.data.MainModel
import com.koleychik.feature_buy_api.BuyRepository
import javax.inject.Inject

internal class BuyRepositoryImpl @Inject constructor(): BuyRepository {
    override fun buy(model: MainModel) {
//        Toast.makeText(context, "Model was bought!!!", Toast.LENGTH_LONG).show()
    }
}