package com.koleychik.feature_clothes.screen

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.koleychik.data.MainModel
import com.koleychik.feature_buy_api.BuyRepository
import com.koleychik.feature_clothes.repository.ClothesFeatureRepository
import javax.inject.Inject

internal class ClothesViewModel @Inject constructor(
    private val repository: ClothesFeatureRepository
) : ViewModel() {

    val model = MutableLiveData<MainModel>(null)

    fun getModel() = repository.getModel()

    fun buy(model: MainModel) {
        repository.buy(model)
    }
}