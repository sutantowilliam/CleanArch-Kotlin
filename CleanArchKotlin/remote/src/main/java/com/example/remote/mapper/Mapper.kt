package com.example.remote.mapper

interface Mapper<E, D> {

    fun mapFromCacheModel(type: E): D

    fun mapToCacheModel(type: D): E

    fun mapFromCacheModel(items: List<E>): List<D>

    fun mapToCacheModel(items: List<D>): List<E>

}