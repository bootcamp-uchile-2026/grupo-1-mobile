package cl.bootcamp.stylenow.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun BotonNavegacionHome(
    texto: String,
    onClick: () -> Unit
) {

    Button(
        modifier = Modifier
            .padding(vertical = 8.dp),
        onClick = {
            onClick()
        }
    ) {
        Text(
            text = texto,
            style = MaterialTheme.typography.labelLarge,
            modifier = Modifier
                .padding(vertical = 6.dp, horizontal = 16.dp)
        )
    }
}