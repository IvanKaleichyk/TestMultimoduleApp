package com.koleychik.core_db.api

import com.koleychik.data.MainModel

interface MainDao {

    fun getModel(): MainModel
}