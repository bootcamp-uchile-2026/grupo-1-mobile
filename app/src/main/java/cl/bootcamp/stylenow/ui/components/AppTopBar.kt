package cl.bootcamp.stylenow.ui.components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar(
    titulo: String,
    mostrarBotonAtras: Boolean,
    mostrarActionIcons: Boolean,
    notificacionesSelected: Boolean,
    favoritosSelected: Boolean,
    carritoSelected: Boolean,
    onNavigateBack: () -> Unit,
    onNavigateToCarrito: () -> Unit,
    onNavigateToFavoritos: () -> Unit,
    onNavigateToNotificaciones: () -> Unit
) {

    TopAppBar(
        title = {
            Text(
                text = titulo
            )
        },

        navigationIcon = {
            if(mostrarBotonAtras){
                AppNavigationIconArrowBack(onNavigateBack)
            }
        },

        actions = {
            if (mostrarActionIcons) {

                AppActionIconNotificaciones(notificacionesSelected, onNavigateToNotificaciones)
                AppActionIconFavoritos(favoritosSelected, onNavigateToFavoritos)
                AppActionIconCarrito(carritoSelected, onNavigateToCarrito)
            }
        },

        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
        )
    )
}