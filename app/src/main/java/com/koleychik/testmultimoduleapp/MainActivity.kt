package com.koleychik.testmultimoduleapp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.findNavController
import com.koleychik.testmultimoduleapp.navigation.Navigator
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var navigator: Navigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val navController = findNavController(R.id.nav_host)
//        navController.addOnDestinationChangedListener()

        App.component?.inject(this)
        navigator.bind(findNavController(R.id.nav_host))
//        navigator.startClothesFeature()
    }

    override fun onDestroy() {
        super.onDestroy()
        navigator.unbind()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        Log.d("MAIN_APP", "onBackPressed")
//        navigator.goBack()
    }
}