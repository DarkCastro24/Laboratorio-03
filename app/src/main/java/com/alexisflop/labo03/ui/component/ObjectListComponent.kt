package com.alexisflop.labo03.ui.component

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.mutableStateOf
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.alexisflop.labo03.model.ObjectClass
import com.alexisflop.labo03.viewmodel.DataViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@Composable
fun ObjectListComponent(modifier: Modifier = Modifier) {
    val data = remember { mutableStateOf(listOf<ObjectClass>()) }
    val viewModel = DataViewModel()

    Column(
        modifier = modifier
        .fillMaxWidth()
        .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Button(onClick = {
            GlobalScope.launch(Dispatchers.IO) {
                Thread.sleep(1000)
                data.value = viewModel.getData()
            }
        }) {
            Text(text = "Get OBJECTS from database")
        }
        LazyColumn(modifier = Modifier
            .weight(9f)
            .fillMaxWidth()
            .padding(top = 8.dp, start = 8.dp, end = 8.dp)
        ) {
            items(data.value) { item ->
                ObjectComponent(item)
            }
        }
    }
}
