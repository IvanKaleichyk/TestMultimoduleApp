package com.koleychik.testmultimoduleapp.di.app

import com.koleychik.testmultimoduleapp.App
import com.koleychik.testmultimoduleapp.MainActivity
import dagger.Component
import javax.inject.Singleton

@Component(modules = [AppModule::class, NavigationModule::class])
@Singleton
interface AppComponent {

    fun inject(app: App)
    fun inject(activity: MainActivity)

}