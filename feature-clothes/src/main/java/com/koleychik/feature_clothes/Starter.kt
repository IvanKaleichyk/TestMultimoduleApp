package com.koleychik.feature_clothes

import android.os.Bundle
import androidx.navigation.NavController

interface Starter {

    fun startClothesFragment(navController: NavController, destinationId: Int, bundle: Bundle?)

}