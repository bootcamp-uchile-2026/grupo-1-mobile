package cl.bootcamp.stylenow.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun AppNavigationIconArrowBack(
    onNavigateBack: () -> Unit
) {

    IconButton(
        onClick = {
            onNavigateBack()
        }
    ) {
        Icon(
            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
            contentDescription = "Atrás",
            tint = MaterialTheme.colorScheme.onPrimaryContainer
        )
    }
}