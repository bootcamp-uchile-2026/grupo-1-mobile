package cl.bootcamp.stylenow.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun AppActionIconCarrito(
    selected: Boolean,
    onNavigateToCarrito: () -> Unit
) {

    IconButton(
        onClick = {
            onNavigateToCarrito()
        }
    ) {
        Icon(
            imageVector = if(selected) Icons.Filled.ShoppingCart else Icons.Outlined.ShoppingCart,
            contentDescription = "Ver carrito",
            tint = MaterialTheme.colorScheme.onPrimaryContainer
        )
    }
}