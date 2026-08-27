package cl.bootcamp.stylenow.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.StarOutline
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ItemEstrellasValoracion() {

    Row(
        modifier = Modifier
            .padding(vertical = 16.dp)
    )
    {
        for (i in 1..5) {
            Icon(
                imageVector = Icons.Filled.StarOutline,
                contentDescription = "Estrella de valoración $i"
            )
        }
    }
}