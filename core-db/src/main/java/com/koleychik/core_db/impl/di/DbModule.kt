package com.koleychik.core_db.impl.di

import com.koleychik.core_db.api.CoreDbApi
import com.koleychik.core_db.api.MainDao
import com.koleychik.core_db.impl.MainDaoImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
internal abstract class DbModule {

    @Singleton
    @Binds
    abstract fun provideCoreDbApi(impl : MainDaoImpl): MainDao

}