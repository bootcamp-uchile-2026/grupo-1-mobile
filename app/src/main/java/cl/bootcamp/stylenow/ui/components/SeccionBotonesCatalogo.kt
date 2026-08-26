package cl.bootcamp.stylenow.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SeccionBotonesCatalogo(
    textoBoton1: String,
    textoBoton2: String
) {

    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 24.dp)
    ) {

        Button(
            modifier = Modifier.weight(0.4f),
            onClick = {}
        ) {
            Text(
                text = textoBoton1,
                style = MaterialTheme.typography.bodyMedium
            )
        }

        Spacer(modifier = Modifier.weight(0.2f))

        Button(
            modifier = Modifier.weight(0.4f),
            onClick = {}
        ) {
            Text(
                text = textoBoton2,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}