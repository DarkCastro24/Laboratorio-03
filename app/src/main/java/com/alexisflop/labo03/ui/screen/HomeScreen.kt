package com.alexisflop.labo03.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.alexisflop.labo03.ui.component.InsertDataComponent
import com.alexisflop.labo03.ui.component.ObjectListComponent

@Composable
fun HomeScreen() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        InsertDataComponent(modifier = Modifier.weight(2.5f))
        ObjectListComponent(modifier = Modifier.weight(7.5f))
    }
}

@Preview(showSystemUi = true)
@Composable
private fun HomeScreenPreview() {
    HomeScreen()
}