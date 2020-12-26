package com.koleychik.module_injector

interface ComponentHolder<A : BaseApi, D : BaseDependencies> : BaseComponentHolder {
    fun init(dependency: D)
    fun get(): A

}

interface BaseComponentHolder {
    fun reset()
}

interface BaseApi

interface BaseDependencies