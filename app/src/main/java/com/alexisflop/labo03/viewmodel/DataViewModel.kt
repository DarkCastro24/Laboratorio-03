package com.alexisflop.labo03.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alexisflop.labo03.data.objectList
import com.alexisflop.labo03.model.ObjectClass
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

// Is type ViewModel
class DataViewModel: ViewModel() {
    fun addData(newObjects: List<ObjectClass>){
        viewModelScope.launch {
            objectList.value.addAll(newObjects)
        }
    }

    fun getData(): MutableList<ObjectClass>{
        return objectList.value
    }
}
