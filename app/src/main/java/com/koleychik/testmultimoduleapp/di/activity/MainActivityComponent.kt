package com.koleychik.testmultimoduleapp.di.activity

import com.koleychik.core_annotation.general.PerScreen
import com.koleychik.testmultimoduleapp.MainActivity
import dagger.Component

@PerScreen
@Component(modules = [NavigationModule::class])
interface MainActivityComponent {

    fun inject(activity: MainActivity)

}