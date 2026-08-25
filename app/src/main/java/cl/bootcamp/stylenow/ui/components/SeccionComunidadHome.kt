package cl.bootcamp.stylenow.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SeccionComunidadHome(
    onNavigateToComunidad: () -> Unit
) {

    Text(
        text = "Comunidad",
        style = MaterialTheme.typography.titleLarge,
        modifier = Modifier.padding(bottom = 16.dp)
    )

    Button(
        onClick = {
            onNavigateToComunidad()
        }
    ) {
        Text(
            text = "VER COMUNIDAD",
            style = MaterialTheme.typography.labelLarge,
            modifier = Modifier
                .padding(vertical = 6.dp, horizontal = 16.dp)
        )
    }
}