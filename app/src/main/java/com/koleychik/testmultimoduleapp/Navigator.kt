package com.koleychik.testmultimoduleapp

import androidx.navigation.NavController
import com.koleychik.feature_clothes.ClothesFeatureApi
import com.koleychik.feature_clothes.navigation.ClothesNavigator
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton

@Singleton
class Navigator @Inject constructor(
    private val clothesFeatureApi: Provider<ClothesFeatureApi>
) : ClothesNavigator, MainStarter {

    private var navController: NavController? = null

    fun bind(navController: NavController) {
        this.navController = navController
    }

    fun unbind() {
        navController = null
    }

    override fun goToLikes() {
        if (navController?.currentDestination?.id == R.id.clothesFragment)
            navController?.navigate(R.id.action_clothesFragment_to_likesFragment)
    }

    override fun goToClothesFeature() {
        clothesFeatureApi.get().navigator()
        navController?.navigate(R.id.clothesFragment)
    }
}