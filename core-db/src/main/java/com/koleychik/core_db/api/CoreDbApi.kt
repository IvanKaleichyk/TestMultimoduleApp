package com.koleychik.core_db.api

import com.koleychik.module_injector.BaseApi

interface CoreDbApi: BaseApi {

    fun getMainDao() : MainDao

}