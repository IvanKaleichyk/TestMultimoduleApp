package com.koleychik.testmultimoduleapp.di.app

import com.koleychik.testmultimoduleapp.App
import dagger.Component
import javax.inject.Singleton

@Component(modules = [AppModule::class])
@Singleton
interface AppComponent {

    fun inject(app: App)

}