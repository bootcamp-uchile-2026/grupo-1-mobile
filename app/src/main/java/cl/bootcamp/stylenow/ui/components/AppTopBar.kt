package cl.bootcamp.stylenow.ui.components

import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar(
    titulo: String,
    mostrarBotonAtras: Boolean,
    mostrarCarrito: Boolean,
    onNavigateBack: () -> Unit,
    onNavigateToCarrito: () -> Unit
) {

    CenterAlignedTopAppBar(
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
            if (mostrarCarrito) {
                AppActionIconCarrito(onNavigateToCarrito)
            }
        },

        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
        )
    )
}