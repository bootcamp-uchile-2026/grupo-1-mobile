package cl.bootcamp.stylenow.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun AppActionIconFavoritos(
    selected: Boolean,
    onNavigateToFavoritos: () -> Unit
) {

    IconButton(
        onClick = {
            onNavigateToFavoritos()
        }
    ) {
        Icon(
            imageVector = if(selected) Icons.Filled.Favorite else Icons.Outlined.FavoriteBorder,
            contentDescription = "Ver lista de deseados",
            tint = MaterialTheme.colorScheme.onPrimaryContainer
        )
    }
}