package com.koleychik.feature_clothes

import android.os.Bundle
import androidx.navigation.NavController

class StarterImpl : Starter {

    override fun startClothesFragment(
        navController: NavController,
        destinationId: Int,
        bundle: Bundle?
    ) {
        navController.navigate(destinationId, bundle)
    }
}