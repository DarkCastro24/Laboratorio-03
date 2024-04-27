package com.alexisflop.labo03.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alexisflop.labo03.model.ObjectClass

// Object Map Style into a card
@Composable
fun ObjectComponent(objectClass: ObjectClass) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal =  20.dp, vertical = 6.dp)
    ) {
        Column(modifier = Modifier.padding(8.dp)) {
            Text("Property One: ${objectClass.getPropertyOne()}",
                style = MaterialTheme.typography.labelMedium
            )
            Text("Property Two: ${objectClass.getPropertyTwo()}",
                style = MaterialTheme.typography.labelMedium
            )
        }
    }
}

@Preview(showSystemUi = false)
@Composable
private fun ObjectComponentPreview() {
    val obj = ObjectClass("Property One", "Property Two")
    ObjectComponent(obj)
}
