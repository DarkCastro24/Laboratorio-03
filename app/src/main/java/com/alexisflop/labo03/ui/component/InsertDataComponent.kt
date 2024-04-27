package com.alexisflop.labo03.ui.component

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alexisflop.labo03.model.ObjectClass
import com.alexisflop.labo03.viewmodel.DataViewModel

@Composable
fun InsertDataComponent(modifier: Modifier = Modifier) {
    val txtPropertyOne: MutableState<String> = remember { mutableStateOf("") }
    val txtPropertyTwo: MutableState<String> = remember { mutableStateOf("") }
    val viewModel = DataViewModel()
    val context = LocalContext.current
    val showToast = remember { mutableStateOf(false) }

    if (showToast.value) {
        LaunchedEffect(Unit) {
            Toast.makeText(context, "Data added successfully", Toast.LENGTH_SHORT).show()
            showToast.value = false
        }
    }

    Column(modifier = modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(modifier = Modifier.padding(bottom = 5.dp), text = "Insert your data here")

        TextField(
            modifier = Modifier.padding(bottom = 5.dp),
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            value = txtPropertyOne.value,
            onValueChange = { txtPropertyOne.value = it },
            placeholder = { Text(text = "Insert first property here") }
        )

        TextField(
            modifier = Modifier.padding(bottom = 5.dp),
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            value = txtPropertyTwo.value,
            onValueChange = { txtPropertyTwo.value = it },
            placeholder = { Text(text = "Insert second property here") }
        )

        Button(modifier = Modifier.padding(bottom = 5.dp), onClick = {
            val obj = ObjectClass(txtPropertyOne.value, txtPropertyTwo.value)
            viewModel.addData(listOf(obj))
            txtPropertyOne.value = ""
            txtPropertyTwo.value = ""
            showToast.value = true
        }) {
            Text(text = "Set data to object")
        }

    }
}

@Preview(showSystemUi = false)
@Composable
private fun InsertDataComponentPreview() {
    InsertDataComponent(modifier = Modifier)
}