package com.koleychik.testmultimoduleapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import com.koleychik.testmultimoduleapp.di.activity.DaggerMainActivityComponent
import com.koleychik.testmultimoduleapp.di.activity.MainActivityComponent
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    internal lateinit var navigator: Navigator

    companion object {
        var activityComponent: MainActivityComponent? = null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initActivityComponent()
        activityComponent?.inject(this)
        navigator.bind(findNavController(R.id.nav_host))
    }

    private fun initActivityComponent() {
        if (activityComponent != null) return
        activityComponent = DaggerMainActivityComponent.builder().build()
    }

}