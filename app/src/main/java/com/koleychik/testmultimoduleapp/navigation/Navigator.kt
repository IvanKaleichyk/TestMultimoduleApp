package com.koleychik.testmultimoduleapp.navigation

import android.os.Bundle
import android.util.Log
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import com.koleychik.feature_clothes.ClothesFeatureApi
import com.koleychik.feature_clothes.di.ClothesFeatureComponentHolder
import com.koleychik.feature_clothes.navigation.ClothesNavigator
import com.koleychik.module_injector.BaseApi
import com.koleychik.module_injector.BaseComponentHolder
import com.koleychik.testmultimoduleapp.MainStarter
import com.koleychik.testmultimoduleapp.R
import javax.inject.Inject
import javax.inject.Provider

class Navigator @Inject constructor(
    private val clothesFeatureApi: Provider<ClothesFeatureApi>
) : ClothesNavigator, MainStarter {

    private val listLastComponentHolder = mutableListOf<BaseComponentHolder>()

//    fun goBack() {
//        if (listLastComponentHolder.isEmpty()) return
////        listLastComponentHolder.apply {
////            this[lastIndex].reset()
////            removeLast()
////        }
//        if (listLastComponentHolder.isEmpty()) return
//        getApiFromComponentHolder(listLastComponentHolder[listLastComponentHolder.lastIndex])
//    }

//    private fun getApiFromComponentHolder(componentHolder: BaseComponentHolder) {
//        when (componentHolder) {
//            is ClothesFeatureComponentHolder -> clothesFeatureApi.get()
////            is
//        }
//    }

//    fun clear() {
//        listLastComponentHolder.clear()
//    }

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
                }
            }
            Log.d(
                "MAIN_APP",
                "destination changed id is " + destination.id
            )
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

    override fun goToClothesFeature() {
        listLastComponentHolder.add(ClothesFeatureComponentHolder)
        clothesFeatureApi.get()
        navController?.navigate(R.id.clothesFragment)
    }

//    fun startClothesFeature() {
//        listLastComponentHolder.add(ClothesFeatureComponentHolder)
//        clothesFeatureApi.get()
//    }

}