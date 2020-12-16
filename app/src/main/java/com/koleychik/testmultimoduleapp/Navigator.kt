package com.koleychik.testmultimoduleapp

import androidx.navigation.NavController
import com.koleychik.feature_clothes.ClothesNavigator
import javax.inject.Inject

internal class Navigator @Inject constructor() : ClothesNavigator {

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

}