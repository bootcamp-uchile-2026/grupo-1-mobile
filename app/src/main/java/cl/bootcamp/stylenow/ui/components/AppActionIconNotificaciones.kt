package cl.bootcamp.stylenow.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun AppActionIconNotificaciones(
    selected: Boolean,
    onNavigateToNotificaciones: () -> Unit
) {

    IconButton(
        onClick = {
            onNavigateToNotificaciones()
        }
    ) {
        Icon(
            imageVector = if(selected) Icons.Filled.Notifications else Icons.Outlined.Notifications,
            contentDescription = "Ver notificaciones",
            tint = MaterialTheme.colorScheme.onPrimaryContainer
        )
    }
}