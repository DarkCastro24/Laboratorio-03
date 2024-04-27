package com.alexisflop.labo03.data

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.alexisflop.labo03.model.ObjectClass

val objectList: MutableState<MutableList<ObjectClass>> = mutableStateOf(mutableListOf())