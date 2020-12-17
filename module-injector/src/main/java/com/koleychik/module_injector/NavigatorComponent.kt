package com.koleychik.module_injector

interface NavigatorComponent<F : NavigatorApi> {

    fun init(navigator: F)
    fun get(): F
    fun reset()
}