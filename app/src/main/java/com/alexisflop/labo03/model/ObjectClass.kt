package com.alexisflop.labo03.model

data class ObjectClass(
    private var propertyOne: String,
    private var propertyTwo: String
){
    fun getPropertyOne(): String = propertyOne
    fun getPropertyTwo(): String = propertyTwo
}
