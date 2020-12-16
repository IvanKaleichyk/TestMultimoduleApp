package com.koleychik.module_injector

interface ComponentHolder<A: BaseApi, D: BaseDependencies>{
    fun init(dependency : D)
    fun get(): A
    fun reset()
}

interface BaseApi

interface BaseDependencies