package cl.bootcamp.stylenow.ui.components

import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import cl.bootcamp.stylenow.ui.screens.ScreenRoutes

@Composable
fun AppBottomBar(
    rutaActual: String,
    onNavigateTo: (String) -> Unit
) {

    NavigationBar(
        containerColor = MaterialTheme.colorScheme.surface,
        contentColor = MaterialTheme.colorScheme.onSurface
    ) {

        ScreenRoutes.entries.forEach { pantalla ->

            val estaSeleccionada = rutaActual == pantalla.route

            NavigationBarItem(
                selected = estaSeleccionada,
                label = { Text(pantalla.title) },
                colors = NavigationBarItemColors(
                    selectedIconColor = MaterialTheme.colorScheme.surface,
                    selectedTextColor = MaterialTheme.colorScheme.onSurface,
                    selectedIndicatorColor = MaterialTheme.colorScheme.onSurface,
                    unselectedIconColor = MaterialTheme.colorScheme.onSurface,
                    unselectedTextColor = MaterialTheme.colorScheme.onSurface,
                    disabledIconColor = MaterialTheme.colorScheme.onSurface,
                    disabledTextColor = MaterialTheme.colorScheme.onSurface
                ),
                icon = {
                    Icon(
                        imageVector = if(estaSeleccionada) pantalla.selectedIcon else pantalla.unSelectedIcon,
                        contentDescription = pantalla.title
                    )
                },
                onClick = {

                    if(!estaSeleccionada) {

                        onNavigateTo(pantalla.route)
                    }
                }
            )
        }
    }
}