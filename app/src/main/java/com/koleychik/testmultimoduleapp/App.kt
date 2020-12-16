package com.koleychik.testmultimoduleapp

import android.app.Application
import com.koleychik.testmultimoduleapp.di.app.AppComponent
import com.koleychik.testmultimoduleapp.di.app.AppModule
import com.koleychik.testmultimoduleapp.di.app.DaggerAppComponent

class App : Application() {

    companion object {
        var component: AppComponent? = null
    }

    override fun onCreate() {
        super.onCreate()

        if (component == null) component = initComponent()
        component?.inject(this)
    }

    private fun initComponent(): AppComponent =
        DaggerAppComponent.builder().appModule(AppModule(this)).build()

}