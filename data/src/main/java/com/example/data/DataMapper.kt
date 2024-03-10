package com.example.data

interface DataMapper<T> {
    fun mapToDomain(): T
}