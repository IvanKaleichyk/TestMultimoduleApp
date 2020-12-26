package com.koleychik.testmultimoduleapp.navigation

import android.util.Log
import androidx.navigation.NavController
import com.koleychik.feature_clothes.ClothesFeatureApi
import com.koleychik.feature_clothes.di.ClothesFeatureComponentHolder
import com.koleychik.feature_clothes.navigation.ClothesNavigator
import com.koleychik.testmultimoduleapp.R
import javax.inject.Inject
import javax.inject.Provider

class Navigator @Inject constructor(
    private val clothesFeatureApi: Provider<ClothesFeatureApi>
) : ClothesNavigator{

    private var navController: NavController? = null

    fun bind(navController: NavController) {
        this.navController = navController
        this.navController!!.addOnDestinationChangedListener(createSetOnDestinationListener())
    }

    fun unbind() {
        navController = null
    }

    private fun createSetOnDestinationListener() =
        NavController.OnDestinationChangedListener { controller, destination, arguments ->
            when(destination.id){
                R.id.clothesFragment -> {
                    clothesFeatureApi.get()
                    Log.d("MAIN_APP", "destination changed is clothesFragment" )
                }
            }
            Log.d("MAIN_APP", "destination changed id is " + destination.id)
        }

    override fun goToLikes() {
        Log.d("MAIN_APP", "start go to goToLikes")
//        Log.d("MAIN_APP", navController?.currentDestination?.displayName!!)
        if (navController == null) Log.d("MAIN_APP", "navController == null")

        if (navController?.currentDestination?.id == R.id.clothesFragment) {
//            listLastComponentHolder.add(Like)
            ClothesFeatureComponentHolder.reset()
            navController?.navigate(R.id.action_clothesFragment_to_likesFragment)
        } else Log.d("MAIN_APP", "current destination is not equals")

    }
}