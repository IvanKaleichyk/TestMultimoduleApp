package com.koleychik.core_db.impl.di

import com.koleychik.core_db.api.CoreDbApi
import dagger.Component
import javax.inject.Singleton

@Component(modules = [DbModule::class])
@Singleton
abstract class DbComponent : CoreDbApi {

    companion object {
        @Volatile
        var instance: DbComponent? = null

        fun get(): DbComponent {
            if (instance == null) synchronized(DbComponent::class.java) {
                if (instance == null) instance = DaggerDbComponent.builder().build()
            }
            return instance!!
        }
    }

}