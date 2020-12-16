package com.koleychik.core_db.impl

import com.koleychik.core_db.api.MainDao
import com.koleychik.data.MainModel
import java.util.*
import javax.inject.Inject

internal class MainDaoImpl @Inject constructor(): MainDao {
    override fun getModel()= MainModel(
        Random().nextInt(),
        Random().nextInt().toString(),
        Random().nextInt()
    )
}